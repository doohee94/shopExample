package com.example.demo.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@NoArgsConstructor
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DELIVERY_ID")
    Long id;

    @OneToOne(mappedBy = "deliveryEntity", cascade = CascadeType.ALL)
    OrderEntity orderEntity;

    @Embedded
    Address address;


    @Getter
    @Enumerated(EnumType.STRING)
    DeliveryStatus deliveryStatus;

    @Builder

    public DeliveryEntity(Address address) {
        this.address = address;
        this.deliveryStatus = DeliveryStatus.READY;
    }

    public void addOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
