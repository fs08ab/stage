package com.ssit.stage.common.filter;


import com.ssit.stage.common.helper.CRLFResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 防CRLF注入攻击
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
@WebFilter(filterName = "CRLFFilter", urlPatterns = "*", asyncSupported = true)
public class CRLFFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, new CRLFResponseWrapper((HttpServletResponse) resp));
    }

}
