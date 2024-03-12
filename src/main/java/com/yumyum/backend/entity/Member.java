package com.yumyum.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false, unique = false)
    private String password;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = false)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String profileImagePath;

    @Column(nullable = false, unique = false)
    private String backgroundImagePath;
}
