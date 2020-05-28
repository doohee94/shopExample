package com.example.demo.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends ItemEntity {

    private String author;
    private String isbn;

}
