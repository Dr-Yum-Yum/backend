package com.yumyum.backend.plan.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlan is a Querydsl query type for Plan
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlan extends EntityPathBase<Plan> {

    private static final long serialVersionUID = -1562944919L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlan plan = new QPlan("plan");

    public final com.yumyum.backend.common.domain.QBaseTimeEntity _super = new com.yumyum.backend.common.domain.QBaseTimeEntity(this);

    public final com.yumyum.backend.chat.domain.QChatRoom chatRoom;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final com.yumyum.backend.member.domain.QMember host;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final com.yumyum.backend.restaurant.domain.QRestaurant restaurant;

    public final EnumPath<PlanStatus> status = createEnum("status", PlanStatus.class);

    public final StringPath title = createString("title");

    public QPlan(String variable) {
        this(Plan.class, forVariable(variable), INITS);
    }

    public QPlan(Path<? extends Plan> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlan(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlan(PathMetadata metadata, PathInits inits) {
        this(Plan.class, metadata, inits);
    }

    public QPlan(Class<? extends Plan> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chatRoom = inits.isInitialized("chatRoom") ? new com.yumyum.backend.chat.domain.QChatRoom(forProperty("chatRoom"), inits.get("chatRoom")) : null;
        this.host = inits.isInitialized("host") ? new com.yumyum.backend.member.domain.QMember(forProperty("host")) : null;
        this.restaurant = inits.isInitialized("restaurant") ? new com.yumyum.backend.restaurant.domain.QRestaurant(forProperty("restaurant")) : null;
    }

}

