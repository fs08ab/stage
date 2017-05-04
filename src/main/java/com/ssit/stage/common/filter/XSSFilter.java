package com.ssit.stage.common.filter;


import com.ssit.stage.common.helper.XSSRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 防跨站脚本攻击
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
@WebFilter(filterName = "XSSFilter", urlPatterns = "*", asyncSupported = true)
public class XSSFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(new XSSRequestWrapper((HttpServletRequest) req), resp);
    }
}
