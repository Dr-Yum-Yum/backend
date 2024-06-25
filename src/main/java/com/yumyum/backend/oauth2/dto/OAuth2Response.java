package com.yumyum.backend.oauth2.dto;

import com.yumyum.backend.member.domain.Role;
import com.yumyum.backend.member.domain.SnsType;

public interface OAuth2Response {

    String getName();
    String getEmail();
    SnsType getSnsType();
    Role getRole();
}
