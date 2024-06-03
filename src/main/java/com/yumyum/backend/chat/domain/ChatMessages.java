package com.yumyum.backend.chat.domain;

import com.yumyum.backend.chat.exception.ChatException;
import com.yumyum.backend.member.domain.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.yumyum.backend.chat.domain.MessageType.ENTER;
import static com.yumyum.backend.chat.exception.ChatExceptionCode.CHAT_MEMBER_IS_NOT_IN_ROOM;

@Embeddable
public class ChatMessages {

    @Getter
    @OneToMany(mappedBy = "chatRoom", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ChatMessage> chatMessages = new ArrayList<>();

    void addChatMessage(final ChatMessage chatMessage) {
        chatMessages.add(chatMessage);
    }

    ChatMessage getLastChatMessage() {
        return chatMessages.get(chatMessages.size() - 1);
    }

    ChatMessage getLastEnteringChatMessageByMember(final Member member) {
        return chatMessages.stream()
                .filter(chatMessage -> isEnteringMessageByMember(member, chatMessage))
                .max(Comparator.comparing(ChatMessage::getCreated))
                .orElseThrow(() -> new ChatException(CHAT_MEMBER_IS_NOT_IN_ROOM, member.getId()));
    }

    private Boolean isEnteringMessageByMember(final Member member, final ChatMessage chatMessage) {
        return member.equals(chatMessage.getSender()) && chatMessage.isMatchedMessageType(ENTER);
    }
}
