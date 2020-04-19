package com.raven.cloud.uaa.web.api;

import java.util.StringJoiner;

/**
 * By Raven 2019/9/29
 * 响应数据状态
 */
public class ApiRespEntity<T> {

    //成功
    public static final int STATE_SUCCESS_CODE = 1;
    //失败
    public static final int STATE_FAILURE_CODE = -1;

    //状态码
    public final int code;
    //消息
    public final String msg;
    //数据
    public final T data;

    private ApiRespEntity(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ApiRespEntity success() {
        return success("success", null);
    }

    public static ApiRespEntity success(String message) {
        return success(message, null);
    }

    public static <T> ApiRespEntity<T> success(T body) {
        return success("success", body);
    }

    public static <T> ApiRespEntity<T> success(String message, T body) {
        return new ApiRespEntity<>(STATE_SUCCESS_CODE, message, body);
    }

    public static ApiRespEntity failure() {
        return failure("failure", null);
    }

    public static ApiRespEntity failure(String message) {
        return failure(message, null);
    }

    public static <T> ApiRespEntity<T> failure(T body) {
        return failure("failure", body);
    }

    public static <T> ApiRespEntity<T> failure(String message, T body) {
        return new ApiRespEntity<>(STATE_FAILURE_CODE, message, body);
    }

    public static <T> ApiRespEntity<T> complete(int code, String message, T body) {
        return new ApiRespEntity<>(code, message, body);
    }

    public static ApiRespEntity complete(int code, String message) {
        return complete(code, message, null);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ApiRespEntity.class.getSimpleName() + "[", "]")
                .add("code=" + code)
                .add("message='" + msg + "'")
                .add("transmission=" + data)
                .toString();
    }
}
