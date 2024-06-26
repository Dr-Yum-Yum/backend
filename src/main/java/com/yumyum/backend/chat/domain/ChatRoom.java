package com.yumyum.backend.chat.domain;

import com.yumyum.backend.chat.exception.ChatException;
import com.yumyum.backend.chat.util.RoomTypeAttributeConverter;
import com.yumyum.backend.common.domain.BaseTimeEntity;
import com.yumyum.backend.member.domain.Member;
import com.yumyum.backend.plan.domain.Plan;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

import static com.yumyum.backend.chat.exception.ChatExceptionCode.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "chat_room_id")
    private Long id;

    @Getter
    @NotNull
    @Column(length = 50)
    private String name;

    @Getter
    @NotNull
    @Convert(converter = RoomTypeAttributeConverter.class)
    private RoomType type;

    @Getter
    @NotNull
    private Integer memberCount = 0;

    @Getter
    @NotNull
    private Integer maxMemberCount = 2;

    @Embedded
    private ChatRoomParticipants chatRoomParticipants = new ChatRoomParticipants();

    @Embedded
    private ChatMessages chatMessages = new ChatMessages();

    @OneToMany(mappedBy = "chatRoom", fetch = FetchType.LAZY)
    private List<Plan> plans;

    @Builder
    private ChatRoom(final String name, final RoomType type) {
        this.name = name;
        this.type = type;
    }

    public void increaseMemberCount() {
        if (isFullRoom()) {
            throw new ChatException(CHAT_ROOM_IS_FULL, memberCount);
        }

        memberCount += 1;
    }

    private Boolean isFullRoom() {
        return memberCount.equals(maxMemberCount);
    }

    public void decreaseMemberCount() {
        if (isEmptyRoom()) {
            throw new ChatException(CHAT_ROOM_IS_EMPTY, memberCount);
        }

        memberCount -= 1;
    }

    public Boolean isEmptyRoom() {
        return memberCount == 0;
    }

    public Boolean isEntered(final Member member) {
        return chatRoomParticipants.isMemberEnteredRoom(member);
    }

    public Boolean isMatchedRoomType(final RoomType type) {
        return this.type == type;
    }

    public void updateMaxMemberCount(final Integer maxMemberCount) {
        if (maxMemberCount < memberCount) {
            throw new ChatException(CHAT_MAX_MEMBER_COUNT_SHOULD_BE_BIGGER_THAN_MEMBER_COUNT, maxMemberCount);
        }

        this.maxMemberCount = maxMemberCount;
    }

    public void sendMessage(final ChatMessage chatMessage) {
        chatMessages.addChatMessage(chatMessage);
    }

    public void enterRoom(final ChatMessage chatMessage) {
        final Member newMember = chatMessage.getSender();
        chatRoomParticipants.activateChatRoomMember(this, newMember);

        sendMessage(chatMessage);
        increaseMemberCount();
    }

    public void leaveRoom(final ChatMessage chatMessage) {
        final Member member = chatMessage.getSender();
        chatRoomParticipants.deactivateChatRoomMember(this, member);

        sendMessage(chatMessage);
        decreaseMemberCount();
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages.getChatMessages();
    }

    public List<Member> getActiveMembersInRoom() {
        return chatRoomParticipants.getActiveMembers();
    }

    public List<Member> getAllMembersInRoom() {
        return chatRoomParticipants.getAllMembers();
    }

    public ChatMessage getLastChatMessage() {
        return chatMessages.getLastChatMessage();
    }

    public ChatMessage getLastEnteringChatMessageByMember(final Member member) {
        return chatMessages.getLastEnteringChatMessageByMember(member);
    }
}
