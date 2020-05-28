package com.example.demo.shop.controller;

import com.example.demo.shop.entity.OrderEntity;
import com.example.demo.shop.entity.OrderStatus;
import com.example.demo.shop.service.ShopQueryDslService;
import com.querydsl.core.QueryResults;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/querydsl")
@RequiredArgsConstructor
public class ShopQueryDSLController {

    private final ShopQueryDslService shopQueryDslService;

    //상품 리스트 - ALL  -> 나중에 세개로 나눠...

    //주문 상태별 주문 리스트
    @GetMapping(value = "/orders/list-by-status")
    public QueryResults<OrderEntity> orderListByStatus(OrderStatus status){
        return shopQueryDslService.orderListByStatus(status);
    }

}
