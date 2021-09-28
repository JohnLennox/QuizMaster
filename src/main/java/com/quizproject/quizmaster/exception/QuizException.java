package com.quizproject.quizmaster.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public class QuizException extends NestedRuntimeException {

    private final int status;

    @Nullable
    private final String reason;

    public QuizException(HttpStatus status, @Nullable String reason, @Nullable Throwable cause) {
        super((String)null, cause);
        Assert.notNull(status, "HttpStatus is required");
        this.status = status.value();
        this.reason = reason;
    }
}
