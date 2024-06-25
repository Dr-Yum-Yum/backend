package com.yumyum.backend.restaurant.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurant is a Querydsl query type for Restaurant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurant extends EntityPathBase<Restaurant> {

    private static final long serialVersionUID = 1017673041L;

    public static final QRestaurant restaurant = new QRestaurant("restaurant");

    public final com.yumyum.backend.common.domain.QBaseTimeEntity _super = new com.yumyum.backend.common.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final ListPath<com.yumyum.backend.review.domain.Review, com.yumyum.backend.review.domain.QReview> reviews = this.<com.yumyum.backend.review.domain.Review, com.yumyum.backend.review.domain.QReview>createList("reviews", com.yumyum.backend.review.domain.Review.class, com.yumyum.backend.review.domain.QReview.class, PathInits.DIRECT2);

    public QRestaurant(String variable) {
        super(Restaurant.class, forVariable(variable));
    }

    public QRestaurant(Path<? extends Restaurant> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRestaurant(PathMetadata metadata) {
        super(Restaurant.class, metadata);
    }

}

