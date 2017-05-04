package com.ssit.stage.common.utils;

import com.ssit.stage.common.exception.BaseException;
import com.ssit.stage.common.exception.SystemException;
import com.ssit.stage.common.exception.subtype.ParamInvalidException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

/**
 * ip工具类
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
public class IPUtils {
    private static final Log LOGGER = LogFactory.getLog(IPUtils.class);

    private static final String LOCAL_IP = "127.0.0.1";

    public static String getRemoteIP(HttpServletRequest request) {
        if (null == request) {
            throw new ParamInvalidException();
        }
        String ipAddress = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ipAddress) || StringUtils.equalsIgnoreCase("unknown", ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipAddress) || StringUtils.equalsIgnoreCase("unknown", ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipAddress) || StringUtils.equalsIgnoreCase("unknown", ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (StringUtils.equals(ipAddress, "127.0.0.1") || StringUtils.equals(ipAddress, "0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inetAddress;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    BaseException exception = new SystemException(e);
                    LOGGER.error(exception.getLogMessage());
                    throw exception;
                }
                ipAddress = inetAddress.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个非unknown的有效IP字符串为客户端真实IP,多个IP按照','分割
        if (!StringUtils.isBlank(ipAddress) && ipAddress.length() > 15) {// "***.***.***.***".length()
            // 15
            String[] ipArr = StringUtils.split(ipAddress, ",");
            for (String tempIP : ipArr) {
                if (!StringUtils.isBlank(tempIP) && !StringUtils.equalsIgnoreCase("unknown", tempIP)) {
                    ipAddress = tempIP;
                    break;
                }
            }
        }
        return ipAddress;
    }

    public static String getLocalIP() {
        try {
            for (Enumeration<?> enumeration = NetworkInterface.getNetworkInterfaces(); enumeration.hasMoreElements(); ) {
                NetworkInterface item = (NetworkInterface) enumeration.nextElement();
                // 非虚拟非回路并开启状态
                if ((!item.isVirtual()) && item.isUp() && (!item.isLoopback())) {
                    for (InterfaceAddress address : item.getInterfaceAddresses()) {
                        if (address.getAddress() instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address.getAddress();
                            return inet4Address.getHostAddress();
                        }
                    }
                }
            }
            return LOCAL_IP;
        } catch (IOException e) {
            BaseException exception = new SystemException(e);
            LOGGER.warn(exception.getLogMessage());
            return LOCAL_IP;
        }
    }
}
