package com.yumyum.backend.dto.responseDto;


import com.yumyum.backend.entity.Role;
import com.yumyum.backend.entity.SnsType;

import java.util.Map;

public class NaverResponse implements OAuth2Response{

    private final Map<String, Object> attributes;

    public NaverResponse(Map<String, Object> attributes) {
        this.attributes = (Map<String, Object>) attributes.get("response");
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
        return SnsType.NAVER;
    }

    @Override
    public Role getRole() {
        return Role.USER;
    }
}
