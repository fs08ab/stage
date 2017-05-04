package com.ssit.stage.common.exception.subtype;


import com.ssit.stage.common.constant.ExceptionType;
import com.ssit.stage.common.exception.SystemException;

/**
 * 数据库异常
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
public class DatabaseException extends SystemException {
    private static final ExceptionType exceptionType = ExceptionType.DATABASE_EXCEPTION;

    public DatabaseException() {
        super(exceptionType);
    }

    public DatabaseException(Throwable e) {
        super(exceptionType, e);
    }
}
