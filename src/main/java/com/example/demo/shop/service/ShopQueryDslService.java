package com.example.demo.shop.service;

import com.example.demo.shop.entity.OrderEntity;
import com.example.demo.shop.entity.OrderStatus;
import com.example.demo.shop.repository.ItemRepositoryImpl;
import com.example.demo.shop.repository.OrderRepositoryImpl;
import com.querydsl.core.QueryResults;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopQueryDslService {

    private final ItemRepositoryImpl itemRepositoryImpl;
    private final OrderRepositoryImpl orderRepositoryImpl;

    public QueryResults<OrderEntity> orderListByStatus(OrderStatus status) {
        return orderRepositoryImpl.findList(status);
    }
}
