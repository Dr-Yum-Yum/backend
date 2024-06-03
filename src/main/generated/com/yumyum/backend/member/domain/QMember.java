package com.yumyum.backend.member.domain;

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

    private static final long serialVersionUID = -743969589L;

    public static final QMember member = new QMember("member1");

    public final com.yumyum.backend.common.domain.QBaseTimeEntity _super = new com.yumyum.backend.common.domain.QBaseTimeEntity(this);

    public final StringPath backgroundImagePath = createString("backgroundImagePath");

    public final ListPath<com.yumyum.backend.chat.domain.ChatRoomParticipant, com.yumyum.backend.chat.domain.QChatRoomParticipant> chatRooms = this.<com.yumyum.backend.chat.domain.ChatRoomParticipant, com.yumyum.backend.chat.domain.QChatRoomParticipant>createList("chatRooms", com.yumyum.backend.chat.domain.ChatRoomParticipant.class, com.yumyum.backend.chat.domain.QChatRoomParticipant.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final StringPath email = createString("email");

    public final ListPath<com.yumyum.backend.Freind.domain.Friend, com.yumyum.backend.Freind.domain.QFriend> Friends = this.<com.yumyum.backend.Freind.domain.Friend, com.yumyum.backend.Freind.domain.QFriend>createList("Friends", com.yumyum.backend.Freind.domain.Friend.class, com.yumyum.backend.Freind.domain.QFriend.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final ListPath<com.yumyum.backend.plan.domain.PlanParticipant, com.yumyum.backend.plan.domain.QPlanParticipant> plans = this.<com.yumyum.backend.plan.domain.PlanParticipant, com.yumyum.backend.plan.domain.QPlanParticipant>createList("plans", com.yumyum.backend.plan.domain.PlanParticipant.class, com.yumyum.backend.plan.domain.QPlanParticipant.class, PathInits.DIRECT2);

    public final StringPath profileImagePath = createString("profileImagePath");

    public final ListPath<com.yumyum.backend.review.domain.Review, com.yumyum.backend.review.domain.QReview> reviews = this.<com.yumyum.backend.review.domain.Review, com.yumyum.backend.review.domain.QReview>createList("reviews", com.yumyum.backend.review.domain.Review.class, com.yumyum.backend.review.domain.QReview.class, PathInits.DIRECT2);

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final EnumPath<SnsType> snsType = createEnum("snsType", SnsType.class);

    public final StringPath statusMessage = createString("statusMessage");

    public final ListPath<com.yumyum.backend.wish.domain.Wish, com.yumyum.backend.wish.domain.QWish> wishList = this.<com.yumyum.backend.wish.domain.Wish, com.yumyum.backend.wish.domain.QWish>createList("wishList", com.yumyum.backend.wish.domain.Wish.class, com.yumyum.backend.wish.domain.QWish.class, PathInits.DIRECT2);

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

