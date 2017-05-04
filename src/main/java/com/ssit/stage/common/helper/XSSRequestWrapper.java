package com.ssit.stage.common.helper;

import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 防跨站脚本攻击
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {

    public XSSRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        // return HtmlUtils.htmlEscape(super.getHeader(name));
        return HtmlUtils.htmlEscape(super.getHeader(name));
    }

    @Override
    public String getQueryString() {
        return HtmlUtils.htmlEscape(super.getQueryString());
    }

    @Override
    public String getParameter(String name) {
        return HtmlUtils.htmlEscape(super.getParameter(name));
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values != null) {
            int length = values.length;
            String[] escapeValues = new String[length];
            for (int i = 0; i < length; i++) {
                escapeValues[i] = HtmlUtils.htmlEscape(values[i]);
            }
            return escapeValues;
        }
        return super.getParameterValues(name);
    }
}
