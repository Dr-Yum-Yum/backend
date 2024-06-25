package com.yumyum.backend.plan.domain;

import com.yumyum.backend.chat.domain.ChatRoom;
import com.yumyum.backend.common.domain.BaseTimeEntity;
import com.yumyum.backend.member.domain.Member;
import com.yumyum.backend.restaurant.domain.Restaurant;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Plan extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long id;

    private LocalDateTime date;

    @Column(nullable = false, length = 30)
    private String title;

    @Enumerated(EnumType.STRING)
    private PlanStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member host;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
