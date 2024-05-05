package com.yumyum.backend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlanParticipant is a Querydsl query type for PlanParticipant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlanParticipant extends EntityPathBase<PlanParticipant> {

    private static final long serialVersionUID = 106431322L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlanParticipant planParticipant1 = new QPlanParticipant("planParticipant1");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final QPlan plan;

    public final QMember planParticipant;

    public QPlanParticipant(String variable) {
        this(PlanParticipant.class, forVariable(variable), INITS);
    }

    public QPlanParticipant(Path<? extends PlanParticipant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlanParticipant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlanParticipant(PathMetadata metadata, PathInits inits) {
        this(PlanParticipant.class, metadata, inits);
    }

    public QPlanParticipant(Class<? extends PlanParticipant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.plan = inits.isInitialized("plan") ? new QPlan(forProperty("plan"), inits.get("plan")) : null;
        this.planParticipant = inits.isInitialized("planParticipant") ? new QMember(forProperty("planParticipant")) : null;
    }

}

