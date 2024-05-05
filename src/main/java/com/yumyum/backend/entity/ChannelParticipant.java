package com.yumyum.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ChannelParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "channel_participant_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member channelParticipant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @CreatedDate
    private LocalDateTime created;

    private LocalDateTime lastModified;

    private LocalDateTime deleted;
}
