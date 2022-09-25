package com.faropay.demo.model;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private static final long serialVersionUID = -3120456661796522436L;
    private final String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}