package com.yumyum.backend.common.exception;

import lombok.Getter;

@Getter
public abstract class BusinessException extends RuntimeException{

    private final ExceptionCode exceptionCode;
    private final Object[] rejectedValues;

    protected BusinessException(final ExceptionCode exceptionCode, final Object... rejectedValues) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
        this.rejectedValues = rejectedValues;
    }
}
