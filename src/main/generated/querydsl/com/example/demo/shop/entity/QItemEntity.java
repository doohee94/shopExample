package com.example.demo.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItemEntity is a Querydsl query type for ItemEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemEntity extends EntityPathBase<ItemEntity> {

    private static final long serialVersionUID = -947647773L;

    public static final QItemEntity itemEntity = new QItemEntity("itemEntity");

    public final ListPath<CategoryEntity, QCategoryEntity> categoryEntities = this.<CategoryEntity, QCategoryEntity>createList("categoryEntities", CategoryEntity.class, QCategoryEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> stockQuantity = createNumber("stockQuantity", Integer.class);

    public QItemEntity(String variable) {
        super(ItemEntity.class, forVariable(variable));
    }

    public QItemEntity(Path<? extends ItemEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemEntity(PathMetadata metadata) {
        super(ItemEntity.class, metadata);
    }

}

