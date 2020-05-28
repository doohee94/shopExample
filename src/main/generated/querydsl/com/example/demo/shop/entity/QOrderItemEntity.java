package com.example.demo.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderItemEntity is a Querydsl query type for OrderItemEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderItemEntity extends EntityPathBase<OrderItemEntity> {

    private static final long serialVersionUID = -2089471785L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderItemEntity orderItemEntity = new QOrderItemEntity("orderItemEntity");

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QItemEntity itemEntity;

    public final QOrderEntity orderEntity;

    public final NumberPath<Integer> orderPrice = createNumber("orderPrice", Integer.class);

    public QOrderItemEntity(String variable) {
        this(OrderItemEntity.class, forVariable(variable), INITS);
    }

    public QOrderItemEntity(Path<? extends OrderItemEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderItemEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderItemEntity(PathMetadata metadata, PathInits inits) {
        this(OrderItemEntity.class, metadata, inits);
    }

    public QOrderItemEntity(Class<? extends OrderItemEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.itemEntity = inits.isInitialized("itemEntity") ? new QItemEntity(forProperty("itemEntity")) : null;
        this.orderEntity = inits.isInitialized("orderEntity") ? new QOrderEntity(forProperty("orderEntity"), inits.get("orderEntity")) : null;
    }

}

