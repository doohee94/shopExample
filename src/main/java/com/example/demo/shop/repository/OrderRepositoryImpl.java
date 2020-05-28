package com.example.demo.shop.repository;

import com.example.demo.shop.entity.OrderEntity;
import com.example.demo.shop.entity.OrderStatus;


import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.example.demo.shop.entity.QMemberEntity.memberEntity;
import static com.example.demo.shop.entity.QOrderEntity.orderEntity;
import static com.example.demo.shop.entity.QDeliveryEntity.deliveryEntity;
import static com.example.demo.shop.entity.QOrderItemEntity.orderItemEntity;

@Repository
public class OrderRepositoryImpl extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public OrderRepositoryImpl(JPAQueryFactory queryFactory) {
        super(OrderEntity.class);
        this.queryFactory = queryFactory;
    }


    public QueryResults<OrderEntity> findList(OrderStatus status){

        QueryResults<OrderEntity> list = queryFactory.selectFrom(orderEntity)
                .leftJoin(deliveryEntity).on(orderEntity.id.eq(deliveryEntity.id))
                .leftJoin(memberEntity).on(orderEntity.id.eq(memberEntity.id))
                .leftJoin(orderItemEntity).on(orderEntity.id.eq(orderItemEntity.orderEntity.id))
                .where(orderEntity.orderStatus.eq(status))
                .fetchResults();

        return list;
    }



}
