package com.yumyum.backend.chat.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChatRoom is a Querydsl query type for ChatRoom
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChatRoom extends EntityPathBase<ChatRoom> {

    private static final long serialVersionUID = 703534530L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChatRoom chatRoom = new QChatRoom("chatRoom");

    public final com.yumyum.backend.common.domain.QBaseTimeEntity _super = new com.yumyum.backend.common.domain.QBaseTimeEntity(this);

    public final QChatMessages chatMessages;

    public final QChatRoomParticipants chatRoomParticipants;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> maxMemberCount = createNumber("maxMemberCount", Integer.class);

    public final NumberPath<Integer> memberCount = createNumber("memberCount", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final StringPath name = createString("name");

    public final ListPath<com.yumyum.backend.plan.domain.Plan, com.yumyum.backend.plan.domain.QPlan> plans = this.<com.yumyum.backend.plan.domain.Plan, com.yumyum.backend.plan.domain.QPlan>createList("plans", com.yumyum.backend.plan.domain.Plan.class, com.yumyum.backend.plan.domain.QPlan.class, PathInits.DIRECT2);

    public final EnumPath<RoomType> type = createEnum("type", RoomType.class);

    public QChatRoom(String variable) {
        this(ChatRoom.class, forVariable(variable), INITS);
    }

    public QChatRoom(Path<? extends ChatRoom> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChatRoom(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChatRoom(PathMetadata metadata, PathInits inits) {
        this(ChatRoom.class, metadata, inits);
    }

    public QChatRoom(Class<? extends ChatRoom> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chatMessages = inits.isInitialized("chatMessages") ? new QChatMessages(forProperty("chatMessages")) : null;
        this.chatRoomParticipants = inits.isInitialized("chatRoomParticipants") ? new QChatRoomParticipants(forProperty("chatRoomParticipants")) : null;
    }

}

