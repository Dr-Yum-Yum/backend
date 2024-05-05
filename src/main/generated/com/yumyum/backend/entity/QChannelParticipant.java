package com.yumyum.backend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChannelParticipant is a Querydsl query type for ChannelParticipant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChannelParticipant extends EntityPathBase<ChannelParticipant> {

    private static final long serialVersionUID = 655357216L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChannelParticipant channelParticipant1 = new QChannelParticipant("channelParticipant1");

    public final QChannel channel;

    public final QMember channelParticipant;

    public final DateTimePath<java.time.LocalDateTime> created = createDateTime("created", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> deleted = createDateTime("deleted", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> lastModified = createDateTime("lastModified", java.time.LocalDateTime.class);

    public QChannelParticipant(String variable) {
        this(ChannelParticipant.class, forVariable(variable), INITS);
    }

    public QChannelParticipant(Path<? extends ChannelParticipant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChannelParticipant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChannelParticipant(PathMetadata metadata, PathInits inits) {
        this(ChannelParticipant.class, metadata, inits);
    }

    public QChannelParticipant(Class<? extends ChannelParticipant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.channel = inits.isInitialized("channel") ? new QChannel(forProperty("channel")) : null;
        this.channelParticipant = inits.isInitialized("channelParticipant") ? new QMember(forProperty("channelParticipant")) : null;
    }

}

