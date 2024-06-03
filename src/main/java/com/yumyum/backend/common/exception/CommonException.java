package com.yumyum.backend.common.exception;

public class CommonException extends BusinessException{

    public CommonException(final ExceptionCode exceptionCode, final Object... rejectedValues) {
        super(exceptionCode, rejectedValues);
    }
}
