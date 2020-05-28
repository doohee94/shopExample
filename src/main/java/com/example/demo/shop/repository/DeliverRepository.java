package com.example.demo.shop.repository;

import com.example.demo.shop.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  DeliverRepository extends JpaRepository<DeliveryEntity, Long> {
}
