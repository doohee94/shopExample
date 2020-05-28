package com.example.demo.shop.repository;

import com.example.demo.shop.entity.ItemEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

    @EntityGraph(attributePaths = {"categoryEntities"})
    @Query("select i from ItemEntity i")
    List<ItemEntity> findAllEntityGraph();

}
