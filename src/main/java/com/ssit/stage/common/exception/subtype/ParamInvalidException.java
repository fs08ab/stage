package com.ssit.stage.common.exception.subtype;


import com.ssit.stage.common.constant.ExceptionType;
import com.ssit.stage.common.exception.BizException;

/**
 * 参数不合法异常
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
public class ParamInvalidException extends BizException {
    private static final ExceptionType exceptionType = ExceptionType.PARAMS_INVALID;

    public ParamInvalidException() {
        super(exceptionType);
    }
}
