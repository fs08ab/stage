package com.ssit.stage.common.filter;


import com.ssit.stage.common.holder.PropertiesHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域访问过滤器
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
@WebFilter(filterName = "CrossDomainAccessFilter", urlPatterns = "*", asyncSupported = true)
public class CrossDomainAccessFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Access-Control-Allow-Origin", PropertiesHolder.ACCESS_CONTROL_ALLOW_ORIGIN);
        response.setHeader("Access-Control-Allow-Methods", PropertiesHolder.ACCESS_CONTROL_ALLOW_METHODS);
        response.setHeader("Access-Control-Max-Age", PropertiesHolder.ACCESS_CONTROL_MAX_AGE);
        response.setHeader("Access-Control-Allow-Headers", PropertiesHolder.ACCESS_CONTROL_ALLOW_HEADERS);
        response.setHeader("Access-Control-Allow-Credentials", PropertiesHolder.ACCESS_CONTROL_ALLOW_CREDENTIALS);
        chain.doFilter(req, resp);
    }
}
