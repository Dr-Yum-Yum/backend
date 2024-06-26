package com.yumyum.backend.oauth2.dto;

import com.yumyum.backend.member.domain.Role;
import com.yumyum.backend.member.domain.SnsType;

import java.util.Map;

public class GoogleResponse implements OAuth2Response{

    private final Map<String, Object> attributes;

    public GoogleResponse(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return attributes.get("name").toString();
    }

    @Override
    public String getEmail() {
        return attributes.get("email").toString();
    }

    @Override
    public SnsType getSnsType() {
        return SnsType.GOOGLE;
    }

    @Override
    public Role getRole() {
        return Role.USER;
    }
}
