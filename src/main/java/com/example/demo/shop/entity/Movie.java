package com.example.demo.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Getter
@Setter
public class Movie extends ItemEntity{

    private String director;
    private  String actor;

}
