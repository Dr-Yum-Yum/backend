package com.yumyum.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Friend extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "friend_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private Long fromMemberId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member toMemberId;

    @Enumerated(EnumType.STRING)
    private FriendStatus status;
}
