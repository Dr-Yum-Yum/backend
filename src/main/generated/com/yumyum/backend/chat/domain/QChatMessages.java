package com.yumyum.backend.chat.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChatMessages is a Querydsl query type for ChatMessages
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QChatMessages extends BeanPath<ChatMessages> {

    private static final long serialVersionUID = -1141126477L;

    public static final QChatMessages chatMessages1 = new QChatMessages("chatMessages1");

    public final ListPath<ChatMessage, QChatMessage> chatMessages = this.<ChatMessage, QChatMessage>createList("chatMessages", ChatMessage.class, QChatMessage.class, PathInits.DIRECT2);

    public QChatMessages(String variable) {
        super(ChatMessages.class, forVariable(variable));
    }

    public QChatMessages(Path<? extends ChatMessages> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChatMessages(PathMetadata metadata) {
        super(ChatMessages.class, metadata);
    }

}

