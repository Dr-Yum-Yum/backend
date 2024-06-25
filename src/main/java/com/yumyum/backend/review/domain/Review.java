package com.yumyum.backend.review.domain;

import com.yumyum.backend.common.domain.BaseTimeEntity;
import com.yumyum.backend.member.domain.Member;
import com.yumyum.backend.restaurant.domain.Restaurant;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(nullable = false)
    @ColumnDefault("0.0")
    private Double score;

    @Column(nullable = false, length = 500)
    private String contents;

    @Column(nullable = false)
    private LocalDateTime dateOfVisit;

    @Column(nullable = true, unique = true)
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member reviewer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
