package com.example.demo.shop.entity.dto;

import com.example.demo.shop.entity.Address;
import com.example.demo.shop.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {

    private String name;
    private Address address;


    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .name(this.name)
                .address(this.address)
                .build();
    }


}
