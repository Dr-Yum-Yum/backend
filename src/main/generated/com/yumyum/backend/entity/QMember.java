package com.yumyum.backend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -951681654L;

    public static final QMember member = new QMember("member1");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final StringPath backgroundImagePath = createString("backgroundImagePath");

    public final ListPath<ChannelParticipant, QChannelParticipant> channels = this.<ChannelParticipant, QChannelParticipant>createList("channels", ChannelParticipant.class, QChannelParticipant.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final StringPath email = createString("email");

    public final ListPath<Friend, QFriend> Friends = this.<Friend, QFriend>createList("Friends", Friend.class, QFriend.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath loginId = createString("loginId");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final ListPath<PlanParticipant, QPlanParticipant> plans = this.<PlanParticipant, QPlanParticipant>createList("plans", PlanParticipant.class, QPlanParticipant.class, PathInits.DIRECT2);

    public final StringPath profileImagePath = createString("profileImagePath");

    public final ListPath<Review, QReview> reviews = this.<Review, QReview>createList("reviews", Review.class, QReview.class, PathInits.DIRECT2);

    public final StringPath statusMessage = createString("statusMessage");

    public final ListPath<Wish, QWish> wishList = this.<Wish, QWish>createList("wishList", Wish.class, QWish.class, PathInits.DIRECT2);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

