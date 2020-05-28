package com.example.demo.shop.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    Long id;

    String name;

    @Embedded
    Address address;

    @OneToMany(mappedBy = "memberEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<OrderEntity> orders;

    @Builder
    public MemberEntity(String name, Address address){
        this.name = name;
        this.address = address;
    }

}
