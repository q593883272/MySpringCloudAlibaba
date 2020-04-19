package com.raven.cloud.uaa.web.exception;

import com.raven.cloud.uaa.web.api.ApiRespEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.raven.cloud.uaa.web.*")
public class ApiExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ApiRespEntity exception(Throwable throwable) {
        return ApiRespEntity.failure(throwable.getClass().getName() + ": " + throwable.getMessage());
    }
}
