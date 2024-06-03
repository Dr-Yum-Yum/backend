package com.yumyum.backend.oauth2.service;

import com.yumyum.backend.oauth2.dto.*;
import com.yumyum.backend.member.domain.Member;
import com.yumyum.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;

        if(registrationId.equals("naver")){
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        }else if(registrationId.equals("kakao")){
            oAuth2Response = new KakaoResponse(oAuth2User.getAttributes());
        }else if(registrationId.equals("google")){
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }

        Optional<Member> findMember = memberRepository.findByEmail(oAuth2Response.getEmail());
        if(findMember.isEmpty()){
            Member saveMember = Member.builder()
                    .name(oAuth2Response.getName())
                    .email(oAuth2Response.getEmail())
                    .nickname(oAuth2Response.getName())
                    .snsType(oAuth2Response.getSnsType())
                    .role(oAuth2Response.getRole())
                    .build();

            memberRepository.save(saveMember);
        }else{
            findMember.get().changeNameAndEmail(oAuth2Response);
            memberRepository.save(findMember.get());
        }

        return CustomOAuth2User.builder()
                .name(oAuth2Response.getName())
                .email(oAuth2Response.getEmail())
                .snsType(oAuth2Response.getSnsType())
                .role(oAuth2Response.getRole())
                .build();
    }
}
