package com.ssit.stage.common.exception;


import com.ssit.stage.common.constant.ExceptionType;

/**
 * <p>Description: 业务异常类的基类</p>
 * Created by Fs on 2017/3/6 18:45
 */
public class BizException extends BaseException {
    private static final ExceptionType exceptionType = ExceptionType.BIZ_EXCEPTION;

    public BizException(String exceptionCode, String exceptionMsg) {
        super(exceptionCode, exceptionMsg);
    }


    public BizException(String extMsg) {
        this(exceptionType.getCode(), exceptionType.getMessage(extMsg));
    }

    public BizException() {
        super(exceptionType);
    }

    public BizException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
