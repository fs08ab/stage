package com.ssit.stage.common.helper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.Arrays;

/**
 * 防CRLF注入攻击
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
public class CRLFResponseWrapper extends HttpServletResponseWrapper {
    /**
     * http head name 不允许出现的字符
     */
    private static final char[] specials_chars = new char[]{'\n', '\r'};

    static {
        Arrays.sort(specials_chars);
    }

    public CRLFResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        super.sendError(sc, filterHeaderValue(msg));
    }

    @Override
    public void sendRedirect(String location) throws IOException {
        super.sendRedirect(filterHeaderValue(location));
    }

    @Override
    public void setHeader(String name, String value) {
        super.setHeader(filterHeaderName(name), filterHeaderValue(value));
    }

    @Override
    public void addHeader(String name, String value) {
        super.addHeader(filterHeaderName(name), filterHeaderValue(value));
    }

    @Override
    public void setDateHeader(String name, long date) {
        super.setDateHeader(filterHeaderName(name), date);
    }

    @Override
    public void addDateHeader(String name, long date) {
        super.addDateHeader(filterHeaderName(name), date);
    }

    @Override
    public void setIntHeader(String name, int value) {
        super.setIntHeader(filterHeaderName(name), value);
    }

    @Override
    public void addIntHeader(String name, int value) {
        super.addIntHeader(filterHeaderName(name), value);
    }

    @Override
    public void setContentType(String contentType) {
        super.setContentType(filterHeaderValue(contentType));
    }

    /**
     * 过滤头信息名字中的非法字符，避免CRLF注入攻击
     */
    private static String filterHeaderName(String name) {
        if (name == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(name.length());
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c > 32 && c < 127 && Arrays.binarySearch(specials_chars, c) < 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 过滤头信息值中的非法字符，避免CRLF注入攻击
     */
    private static String filterHeaderValue(String value) {
        if (value == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(value.length());
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c >= 32 && c < 127) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
