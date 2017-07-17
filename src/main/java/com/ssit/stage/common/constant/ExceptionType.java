package com.ssit.stage.common.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义异常类型
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
public enum ExceptionType {
    SYSTEM_EXCEPTION("01_001", "服务端发生异常"),

    BIZ_EXCEPTION("02_001", "业务异常：{0}"),

    DATABASE_EXCEPTION("01_002", "操作数据库发生异常"),

    FILE_EXCEPTION("01_003", "处理文件发生异常"),

    PARAMS_INVALID("02_002", "参数非法：{+}");

    private String code;
    private String message;

    ExceptionType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        String placeholder = "\\{(\\+|\\d+)}";
        String extTips = String.format("(:|：)?(\\[|【)?(%s)+(]|】)?", placeholder);

        Pattern pattern = Pattern.compile(extTips);
        Matcher matcher = pattern.matcher(message);
        return matcher.replaceAll("");
    }

    public String getMessage(String... msg) {
        if (msg == null) {
            return getMessage();
        }

        String placeholder = "\\{(\\+|\\d+)}";
        Pattern pattern1 = Pattern.compile(placeholder);
        Matcher matcher1 = pattern1.matcher(message);
        while (matcher1.find()) {
            String group = matcher1.group();
            if (Pattern.matches("\\D+", group)) {
                message = message.replace(group, StringUtils.join(msg, " "));
            } else {
                Integer i = Integer.valueOf(group.replaceAll("\\D*", ""));
                if (msg.length <= i || StringUtils.isBlank(msg[i])) {
                    String tempReg = String.format("(:|：)?(\\[|【)?(\\%s)+(]|】)?", group);
                    message = message.replaceAll(tempReg, "");
                } else {
                    message = message.replace(group, msg[i]);
                }
            }
        }

        return message;
    }

    public static ExceptionType get(String code) {
        ExceptionType[] values = ExceptionType.values();
        for (ExceptionType eType : values) {
            if (eType.getCode().equals(code)) {
                return eType;
            }
        }
        return null;
    }
}
