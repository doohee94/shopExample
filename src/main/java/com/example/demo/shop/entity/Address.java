package com.example.demo.shop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@NoArgsConstructor
@Embeddable
@Getter
@Setter
public class Address {

    String city;
    String load;
    String zipCode;


}
