package com.example.demo.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    int orderPrice;
    int count;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    @JsonBackReference
    OrderEntity orderEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    @JsonBackReference
    ItemEntity itemEntity;

    @Builder
    public OrderItemEntity(ItemEntity itemEntity, int count) {
        this.itemEntity = itemEntity;
        this.count = count;
        this.orderPrice = itemEntity.getPrice() * count;
    }

    public void addOrderEntity(OrderEntity orderEntity){
        this.orderEntity = orderEntity;
    }
}
