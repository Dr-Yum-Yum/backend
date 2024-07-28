package com.yumyum.backend.jwt.domain;

public interface AuthService {
    boolean isAuthenticated(String authToken);
}
