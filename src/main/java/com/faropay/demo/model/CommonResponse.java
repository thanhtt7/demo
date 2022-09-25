package com.faropay.demo.model;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResponse<T> {
    private int code;
    private String message;

    private T data;

    public CommonResponse(T data) {
        this.data = data;
    }

    public CommonResponse(HttpStatus status) {
        code = status.value();
        message = status.getReasonPhrase();
    }

    public CommonResponse(HttpStatus status, T data) {
        code = status.value();
        message = status.getReasonPhrase();
        this.data = data;
    }
}
