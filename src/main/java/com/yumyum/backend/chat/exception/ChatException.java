package com.yumyum.backend.chat.exception;

import com.yumyum.backend.common.exception.BusinessException;
import com.yumyum.backend.common.exception.ExceptionCode;

public class ChatException extends BusinessException {
    public ChatException(final ExceptionCode exceptionCode, final Object... rejectedValues) {
        super(exceptionCode, rejectedValues);
    }

}
