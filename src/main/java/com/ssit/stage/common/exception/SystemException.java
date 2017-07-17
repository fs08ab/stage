package com.ssit.stage.common.exception;


import com.ssit.stage.common.constant.ExceptionType;

/**
 * <p>Description: 系统异常类的基类</p>
 * Created by Fs on 2017/3/6 18:45
 */
public class SystemException extends BaseException {
    private static final ExceptionType exceptionType = ExceptionType.SYSTEM_EXCEPTION;

    public SystemException(String exceptionCode, String exceptionMsg) {
        super(exceptionCode, exceptionMsg);
    }

    public SystemException(String exceptionCode, String exceptionMsg, Throwable e) {
        super(exceptionCode, exceptionMsg, e);
    }

    public SystemException() {
        super(exceptionType);
    }

    public SystemException(Throwable e) {
        super(exceptionType, e);
    }

    protected SystemException(ExceptionType exceptionType) {
        super(exceptionType);
    }

    public SystemException(ExceptionType exceptionType, Throwable e) {
        super(exceptionType, e);
    }
}
