package com.ssit.stage.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.ssit.stage.common.exception.SystemException;
import com.ssit.stage.common.helper.RepeatableRequestWrapper;
import com.ssit.stage.common.holder.PropertiesHolder;
import com.ssit.stage.common.utils.IPUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过过滤器实现记录外部访问系统的日志的功能
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
@WebFilter(filterName = "AccessLogFilter", urlPatterns = {"*.json", "*.ftl"}, asyncSupported = true)
public class AccessLogFilter extends HttpServlet implements Filter {
    private static final Log LOGGER = LogFactory.getLog(AccessLogFilter.class);

    public void init(FilterConfig config) throws ServletException {
        LOGGER.info("server starting");
    }

    public void destroy() {
        super.destroy();
        LOGGER.info("server shutting down");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (!PropertiesHolder.ACCESS_LOG_SWITCH) {
            chain.doFilter(req, resp);
            return;
        }

        if (!(req instanceof HttpServletRequest)) {
            chain.doFilter(req, resp);
            return;
        }

        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        String uri = httpReq.getRequestURI();
        if (PropertiesHolder.ACCESS_LOG_EXCLUDE_URLS.contains(uri)) {
            chain.doFilter(req, resp);
            return;
        }

        String logContent = null;
        String sessionId = null;
        int statusCode = 500;
        Date accessTime = new Date();
        try {
            RepeatableRequestWrapper requestWrapper = new RepeatableRequestWrapper(httpReq);
            sessionId = requestWrapper.getSession().getId();
            logContent = this.getLogContent(requestWrapper);

            chain.doFilter(requestWrapper, httpResp);
            statusCode = httpResp.getStatus();
        } catch (RuntimeException e) {
            SystemException exception = new SystemException(e);
            LOGGER.fatal(exception.getLogMessage("access log filter throw exception:"), e);
            throw exception;
        } finally {
            LOGGER.info(formatAccessLog(httpReq, statusCode, logContent, sessionId, accessTime));
        }
    }

    private String getLogContent(RepeatableRequestWrapper request) throws IOException {
        String method = request.getMethod();
        if ("GET".equals(method)) {
            return request.getQueryString() == null ? "" : "?" + request.getQueryString();
        } else {
            Map<String, String[]> parameterMap;
            String contentType = request.getContentType();
            if (StringUtils.containsIgnoreCase(contentType, "application/json") || StringUtils.containsIgnoreCase(contentType, "text/json")
                    || StringUtils.containsIgnoreCase(contentType, "text/javascript")) {
                // 表示是json
                parameterMap = JSONObject.parseObject(request.getInputStream(), Map.class, Feature.AutoCloseSource);
            } else {
                parameterMap = request.getParameterMap();
            }
            String key;
            Map<String, Object> map = new HashMap<>();
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                key = entry.getKey();
                if (PropertiesHolder.ACCESS_LOG_ENCRYPT_PARAMS.contains(key.toLowerCase())) {
                    map.put(key, "XXX");
                } else {
                    map.put(key, entry.getValue());
                }
            }

            return JSONObject.toJSONString(map);
        }
    }

    private String formatAccessLog(HttpServletRequest request, int stateCode, String logContent, String sessionId, Date accessTime) {
        String log = null;
        try {
            // user ip
            String remoteIp = IPUtils.getRemoteIP(request);
            // request time
            SimpleDateFormat format = new SimpleDateFormat(PropertiesHolder.DEFAULT_TIME_PATTERN);
            String accessTimeStr = format.format(accessTime);
            // request method
            String method = request.getMethod();
            // request url
            String requestURI = request.getRequestURI();
            // log content
            // protocol
            String protocol = request.getProtocol();
            // state code
            // referrer
            String referrer = request.getHeader("Referer");
            referrer = StringUtils.isBlank(referrer) ? "-" : referrer;
            // user agent
            String userAgent = request.getHeader("User-Agent");
            userAgent = StringUtils.isBlank(userAgent) ? "-" : userAgent;
            // 响应时间
            String cost = String.valueOf(System.currentTimeMillis() - accessTime.getTime());
            // session sessionId

            log = String.format("%s [%s +0800] \"%s %s%s %s\" %s - \"%s\" \"%s\" %s \"%s\"",
                    remoteIp, accessTimeStr, method, requestURI, logContent, protocol, stateCode, referrer, userAgent, cost, sessionId);
        } catch (Exception e) {
            SystemException exception = new SystemException(e);
            LOGGER.fatal(exception.getLogMessage("format access log throw exception:"), e);
        }
        return log;
    }
}
