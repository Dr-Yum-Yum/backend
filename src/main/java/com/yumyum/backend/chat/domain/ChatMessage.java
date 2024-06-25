package com.yumyum.backend.chat.domain;

import com.yumyum.backend.chat.util.MessageTypeAttributeConverter;
import com.yumyum.backend.common.domain.BaseTimeEntity;
import com.yumyum.backend.member.domain.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_message_id")
    private Long id;

    @Getter
    @NotNull
    @Convert(converter = MessageTypeAttributeConverter.class)
    private MessageType type;

    @Getter
    @NotNull
    @Column(length = 500)
    private String content;

    @Getter
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private Member sender;

    @Getter
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @Builder
    private ChatMessage(final ChatRoom chatRoom, final Member sender, final String content, final MessageType type) {
        this.type = type;
        this.content = content;
        this.chatRoom = chatRoom;
        this.sender = sender;
    }

    public void updateContent(final String content) {
        this.content = content;
    }

    public Boolean isMatchedMessageType(final MessageType type) {
        return this.type == type;
    }
}
