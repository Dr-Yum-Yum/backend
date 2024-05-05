package com.yumyum.backend.dto.responseDto;

import com.yumyum.backend.entity.Role;
import com.yumyum.backend.entity.SnsType;

import java.util.Map;

public class KakaoResponse implements OAuth2Response{

    private final Map<String, Object> kakaoAccount;
    private final Map<String, Object> kakaoProfile;

    public KakaoResponse(Map<String, Object> attributes) {
        this.kakaoAccount = (Map<String,Object>) attributes.get("kakao_account");
        this.kakaoProfile = (Map<String, Object>) kakaoAccount.get("profile");
    }

    @Override
    public String getName() {
        return kakaoProfile.get("nickname").toString();
    }

    @Override
    public String getEmail() {
        return kakaoAccount.get("email").toString();
    }

    @Override
    public SnsType getSnsType() {
        return SnsType.KAKAO;
    }

    @Override
    public Role getRole() {
        return Role.USER;
    }
}
