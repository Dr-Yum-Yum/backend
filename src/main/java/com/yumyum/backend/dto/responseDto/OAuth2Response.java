package com.yumyum.backend.dto.responseDto;

import com.yumyum.backend.entity.Role;
import com.yumyum.backend.entity.SnsType;

public interface OAuth2Response {

    String getName();
    String getEmail();
    SnsType getSnsType();
    Role getRole();
}
