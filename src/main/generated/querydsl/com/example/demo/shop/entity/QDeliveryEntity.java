package com.example.demo.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDeliveryEntity is a Querydsl query type for DeliveryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDeliveryEntity extends EntityPathBase<DeliveryEntity> {

    private static final long serialVersionUID = 937685124L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDeliveryEntity deliveryEntity = new QDeliveryEntity("deliveryEntity");

    public final QAddress address;

    public final EnumPath<DeliveryStatus> deliveryStatus = createEnum("deliveryStatus", DeliveryStatus.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOrderEntity orderEntity;

    public QDeliveryEntity(String variable) {
        this(DeliveryEntity.class, forVariable(variable), INITS);
    }

    public QDeliveryEntity(Path<? extends DeliveryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDeliveryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDeliveryEntity(PathMetadata metadata, PathInits inits) {
        this(DeliveryEntity.class, metadata, inits);
    }

    public QDeliveryEntity(Class<? extends DeliveryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
        this.orderEntity = inits.isInitialized("orderEntity") ? new QOrderEntity(forProperty("orderEntity"), inits.get("orderEntity")) : null;
    }

}

