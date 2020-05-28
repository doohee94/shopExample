package com.example.demo.shop.repository;

import com.example.demo.shop.entity.OrderEntity;
import com.example.demo.shop.entity.OrderStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @EntityGraph(attributePaths = {"deliveryEntity", "memberEntity", "orderItemEntities"})
    @Query("select o from OrderEntity o where o.orderStatus = :status")
    List<OrderEntity> findByOrderStatus(OrderStatus status);
}
