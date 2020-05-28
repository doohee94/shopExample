package com.example.demo.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategoryEntity is a Querydsl query type for CategoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategoryEntity extends EntityPathBase<CategoryEntity> {

    private static final long serialVersionUID = 5448206L;

    public static final QCategoryEntity categoryEntity = new QCategoryEntity("categoryEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<ItemEntity, QItemEntity> items = this.<ItemEntity, QItemEntity>createList("items", ItemEntity.class, QItemEntity.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QCategoryEntity(String variable) {
        super(CategoryEntity.class, forVariable(variable));
    }

    public QCategoryEntity(Path<? extends CategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategoryEntity(PathMetadata metadata) {
        super(CategoryEntity.class, metadata);
    }

}

