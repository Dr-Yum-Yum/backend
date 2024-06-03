package com.yumyum.backend.chat.domain;

import com.yumyum.backend.common.domain.BaseTimeEntity;
import com.yumyum.backend.member.domain.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"member_id", "chat_room_id"}))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"member", "chatRoom"}, callSuper = false)
public class ChatRoomParticipant extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_participant_id")
    private Long id;

    @NotNull
    private boolean active = TRUE;

    @Getter
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Getter
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @Builder
    private ChatRoomParticipant(final Member member, final ChatRoom chatRoom) {
        this.member = member;
        this.chatRoom = chatRoom;
    }

    public void activate() {
        active = TRUE;
    }

    public void deactivate() {
        active = FALSE;
    }

    public Boolean isActive() {
        return active;
    }
}
