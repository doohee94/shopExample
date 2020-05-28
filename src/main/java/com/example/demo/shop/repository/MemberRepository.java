package com.example.demo.shop.repository;

import com.example.demo.shop.entity.MemberEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByName(String name);

    @Query("select m from MemberEntity m  join fetch m.orders")
    List<MemberEntity> findAllJoinFetch(); //inner join

    @EntityGraph(attributePaths = {"orders"})
    @Query("select m from MemberEntity m")
    List<MemberEntity> findAllEntityGraph(); //outerJoin

}
