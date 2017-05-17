package com.ssit.stage.common.exception;

import com.ssit.stage.common.constant.ExceptionType;

/**
 * <p>Description: 自定义异常类的基类</p>
 * <p>Copyright: Copyright (c) 2016 fs all right reserved</p>
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * exceptionType:错误类型
     */
    private ExceptionType exceptionType;

    /**
     * exceptionCode:错误码
     */
    private String exceptionCode;

    BaseException(String exceptionCode, String exceptionMsg) {
        super(exceptionMsg);
        this.exceptionCode = exceptionCode;
        this.exceptionType = ExceptionType.get(exceptionCode);
    }

    BaseException(String exceptionCode, String exceptionMsg, Throwable e) {
        super(exceptionMsg, e);
        this.setStackTrace(e.getStackTrace());
        this.exceptionCode = exceptionCode;
        this.exceptionType = ExceptionType.get(exceptionCode);
    }

    BaseException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionCode = exceptionType.getCode();
        this.exceptionType = exceptionType;
    }

    BaseException(ExceptionType exceptionType, Throwable e) {
        super(exceptionType.getMessage(), e);
        this.setStackTrace(e.getStackTrace());
        this.exceptionCode = exceptionType.getCode();
        this.exceptionType = exceptionType;
    }

    /**
     * 获取异常编码
     *
     * @return 异常编码
     */
    public String getCode() {
        return exceptionCode;
    }

    /**
     * 获取异常的完整描述信息
     *
     * @return 异常的完整描述信息
     */
    @Override
    public String getMessage() {
        //待处理的异常信息
        String message = super.getMessage();
        // 异常根源
        Throwable cause = getRootCause();
        if (cause != null) {
            StringBuilder buf = new StringBuilder();
            if (message != null) {
                buf.append(message).append("; ");
            }
            buf.append("nested exception is ").append(cause);
            return buf.toString();
        } else {
            return message;
        }
    }

    /**
     * 拼接异常的日志信息，方便打印日志
     *
     * @param bizLog 自定义日志内容
     * @return 完整的异常日志信息
     */
    public String getLogMessage(String... bizLog) {
        String errorCode = this.getCode();
        String errorMsg = exceptionType.getMessage(bizLog);
        StackTraceElement traceElement = this.getStackTrace()[0];
        String className = traceElement.getClassName();
        String methodName = traceElement.getMethodName();
        int lineNumber = traceElement.getLineNumber();
        String detailMsg = this.getMessage();

        return String.format("%s:%s - %s.%s() Line:%s\n\t%s", errorCode, errorMsg, className, methodName, lineNumber, detailMsg);
    }

    public String getLogMessage() {
        return getLogMessage((String) null);
    }

    /**
     * <p>
     * 获得嵌套的根异常对象,如果没有,则返回自身
     * </p>
     * <p>
     * 与getRootCause不同之处在于,如果没有根异常对象的话,则返回该异常本身
     * </p>
     *
     * @return 最里层的异常对象, 如果没有, 则返回自身(不可能返回<code>null</code>)
     */
    public Throwable getMostSpecificCause() {
        Throwable rootCause = getRootCause();
        return (rootCause != null ? rootCause : this);
    }

    /**
     * 获得嵌套的根异常对象
     *
     * @return 根异常对象, 如果没有, 则返回<code>null<code>
     */
    public Throwable getRootCause() {
        Throwable rootCause = null;
        Throwable cause = super.getCause();
        while (cause != null && cause != rootCause) {
            rootCause = cause;
            cause = cause.getCause();
        }
        return rootCause;
    }

    /**
     * 检查异常中是否包含给定类型的异常, 这个异常有可能是本身或者嵌套异常链中的一个
     *
     * @param exType 待检查的异常类型
     * @return 异常链中是否存在给定类型的异常
     */
    public boolean contains(Class<?> exType) {
        if (exType == null) {
            return false;
        }

        // 如果类型是该异常本身,返回true
        if (exType.isInstance(this)) {
            return true;
        }

        // 获得嵌套的异常
        Throwable cause = getCause();
        if (cause == this) {
            return false;
        }

        // 查询嵌套异常链中是否存在待检查类型的异常
        if (cause instanceof BaseException) {
            return ((BaseException) cause).contains(exType);
        } else {
            while (cause != null) {
                if (exType.isInstance(cause)) {
                    return true;
                }
                if (cause.getCause() == cause) {
                    break;
                }
                cause = cause.getCause();
            }
            return false;
        }
    }

    /**
     * 将普通的异常转换成自定义的异常类
     */
    public static BaseException boxException(Exception e) {
        if (e == null) {
            return null;
        }
        if (e instanceof BaseException) {
            return (BaseException) e;
        } else {
            return new SystemException(e);
        }
    }
}

