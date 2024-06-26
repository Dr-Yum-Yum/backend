package com.yumyum.backend.oauth2.dto;

import com.yumyum.backend.member.domain.Role;
import com.yumyum.backend.member.domain.SnsType;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Builder
public class CustomOAuth2User implements OAuth2User {

    private String name;
    private String email;
    private SnsType snsType;
    private Role role;

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {

                return role.toString();
            }
        });

        return collection;
    }

    @Override
    public String getName() {

        return name;
    }

    public String getEmail() {
        return email;
    }

    public SnsType getSnsType() {
        return snsType;
    }

    public Role getRole() {
        return role;
    }
}
