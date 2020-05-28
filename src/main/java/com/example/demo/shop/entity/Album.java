package com.example.demo.shop.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
@NoArgsConstructor
public class Album extends ItemEntity{

    private String artist;
    private String ect;

    @Builder
    public Album(String artist, String ect) {
        this.artist = artist;
        this.ect = ect;
    }
}
