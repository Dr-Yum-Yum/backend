package com.yumyum.backend.entity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Role level;

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

    @OneToMany(mappedBy = "channelParticipant", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChannelParticipant> channels;

    @OneToMany(mappedBy = "planParticipant", fetch = FetchType.LAZY)
    private List<PlanParticipant> plans;
}

