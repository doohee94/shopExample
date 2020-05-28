package com.example.demo.shop.repository;

import com.example.demo.shop.entity.ItemEntity;
import com.example.demo.shop.entity.OrderEntity;
import com.example.demo.shop.entity.OrderStatus;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.demo.shop.entity.QCategoryEntity.categoryEntity;
import static com.example.demo.shop.entity.QItemEntity.itemEntity;

@Repository
public class ItemRepositoryImpl extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public ItemRepositoryImpl(JPAQueryFactory queryFactory) {
        super(ItemEntity.class);
        this.queryFactory = queryFactory;
    }

}
