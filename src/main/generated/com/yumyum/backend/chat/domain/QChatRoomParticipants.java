package com.yumyum.backend.chat.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChatRoomParticipants is a Querydsl query type for ChatRoomParticipants
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QChatRoomParticipants extends BeanPath<ChatRoomParticipants> {

    private static final long serialVersionUID = -837955966L;

    public static final QChatRoomParticipants chatRoomParticipants1 = new QChatRoomParticipants("chatRoomParticipants1");

    public final ListPath<ChatRoomParticipant, QChatRoomParticipant> chatRoomParticipants = this.<ChatRoomParticipant, QChatRoomParticipant>createList("chatRoomParticipants", ChatRoomParticipant.class, QChatRoomParticipant.class, PathInits.DIRECT2);

    public QChatRoomParticipants(String variable) {
        super(ChatRoomParticipants.class, forVariable(variable));
    }

    public QChatRoomParticipants(Path<? extends ChatRoomParticipants> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChatRoomParticipants(PathMetadata metadata) {
        super(ChatRoomParticipants.class, metadata);
    }

}

