package com.yumyum.backend.member.domain;

import com.yumyum.backend.chat.domain.ChatRoomParticipant;
import com.yumyum.backend.common.domain.BaseTimeEntity;
import com.yumyum.backend.oauth2.dto.OAuth2Response;
import com.yumyum.backend.Freind.domain.Friend;
import com.yumyum.backend.plan.domain.PlanParticipant;
import com.yumyum.backend.review.domain.Review;
import com.yumyum.backend.wish.domain.Wish;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true, unique = false)
    private String nickname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SnsType snsType;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = true, unique = false)
    private String statusMessage;

    @Column(nullable = true, unique = true)
    private String profileImagePath;

    @Column(nullable = true, unique = true)
    private String backgroundImagePath;

    @OneToMany(mappedBy = "toMember", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Friend> Friends;

    @OneToMany(mappedBy = "reviewer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wish> wishList;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatRoomParticipant> chatRooms;

    @OneToMany(mappedBy = "planParticipant", fetch = FetchType.LAZY)
    private List<PlanParticipant> plans;

    public void changeNameAndEmail(OAuth2Response oAuth2Response){
        this.name = oAuth2Response.getName();
        this.email = oAuth2Response.getEmail();
    }
}

