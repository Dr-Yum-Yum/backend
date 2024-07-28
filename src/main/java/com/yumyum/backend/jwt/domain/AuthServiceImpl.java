package com.yumyum.backend.jwt.domain;

import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtDecoder jwtDecoder;

    public AuthServiceImpl(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    public boolean isAuthenticated(String authToken) {
        try {
            // JWT 토큰을 디코딩하고 유효성을 검사
            Jwt jwt = jwtDecoder.decode(authToken);

            // 필요에 따라 추가적인 검증 로직을 추가할 수 있음
            // 예: 사용자 권한 체크, 특정 클레임 확인 등

            return true; // 토큰이 유효하고 인증되었음을 의미
        } catch (JwtException e) {
            // 토큰이 유효하지 않거나 파싱 오류가 발생한 경우
            return false;
        }
    }
}
