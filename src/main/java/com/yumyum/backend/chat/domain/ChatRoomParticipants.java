package com.yumyum.backend.chat.domain;

import com.yumyum.backend.chat.exception.ChatException;
import com.yumyum.backend.member.domain.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import static com.yumyum.backend.chat.exception.ChatExceptionCode.CHAT_MEMBER_IS_NOT_IN_ROOM;

@Embeddable
public class ChatRoomParticipants {

    @OneToMany(mappedBy = "chatRoom", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ChatRoomParticipant> chatRoomParticipants = new ArrayList<>();

    void activateChatRoomMember(final ChatRoom chatRoom, final Member member) {
        final ChatRoomParticipant chatRoomParticipant = buildChatRoom(chatRoom, member);

        if (chatRoomParticipants.contains(chatRoomParticipant)) {
            final ChatRoomParticipant foundChatRoomMember = findChatRoomMember(chatRoom, member);
            foundChatRoomMember.activate();

            return;
        }

        chatRoomParticipants.add(chatRoomParticipant);
    }

    void deactivateChatRoomMember(final ChatRoom chatRoom, final Member member) {
        final ChatRoomParticipant foundChatRoomMember = findChatRoomMember(chatRoom, member);
        foundChatRoomMember.deactivate();
    }

    private ChatRoomParticipant findChatRoomMember(final ChatRoom chatRoom, final Member member) {
        final ChatRoomParticipant chatRoomMember = buildChatRoom(chatRoom, member);

        return chatRoomParticipants.stream()
                .filter(chatRoomMember::equals)
                .findFirst()
                .orElseThrow(() -> new ChatException(CHAT_MEMBER_IS_NOT_IN_ROOM, member.getId(), chatRoom.getId()));
    }

    private ChatRoomParticipant buildChatRoom(final ChatRoom chatRoom, final Member member) {
        return ChatRoomParticipant.builder()
                .member(member)
                .chatRoom(chatRoom)
                .build();
    }

    Boolean isMemberEnteredRoom(final Member member) {
        return chatRoomParticipants.stream()
                .anyMatch(chatRoomMember -> member.equals(chatRoomMember.getMember()));
    }

    List<Member> getActiveMembers() {
        return chatRoomParticipants.stream()
                .filter(ChatRoomParticipant::isActive)
                .map(ChatRoomParticipant::getMember)
                .toList();
    }

    List<Member> getAllMembers() {
        return chatRoomParticipants.stream()
                .map(ChatRoomParticipant::getMember)
                .toList();
    }
}
