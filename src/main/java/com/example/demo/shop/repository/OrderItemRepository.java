package com.example.demo.shop.repository;

import com.example.demo.shop.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

    @Query("select o from OrderItemEntity  o where o.orderEntity.id = :orderId")
    List<OrderItemEntity> findByOrderId(Long orderId);

    @Query("select SUM(o.orderPrice) from OrderItemEntity o where o.orderEntity.id = :orderId group by o.orderEntity.id")
    int checkPrice(Long orderId);
}
