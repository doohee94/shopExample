package com.example.demo.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    Long id;

    LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    @JsonBackReference
    MemberEntity memberEntity;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    List<OrderItemEntity> orderItemEntities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DELIVERY_ID")
    DeliveryEntity deliveryEntity;

    @Builder
    public OrderEntity(List<OrderItemEntity> orderItemEntities, DeliveryEntity deliveryEntity, MemberEntity memberEntity) {

        this.orderDate = LocalDateTime.now();
        this.orderStatus = OrderStatus.ORDER;
        this.deliveryEntity = deliveryEntity;
        this.deliveryEntity.addOrderEntity(this);
        this.memberEntity = memberEntity;

        this.orderItemEntities = orderItemEntities;
        this.orderItemEntities.forEach(e -> e.addOrderEntity(this));
    }

    public void checkDeliveryStatus() throws Exception {
        if (deliveryEntity.getDeliveryStatus().equals(DeliveryStatus.COMP)) {
            throw new Exception("이미 배달 완료");
        }
    }
}
