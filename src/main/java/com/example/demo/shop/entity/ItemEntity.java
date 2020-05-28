package com.example.demo.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Getter
@Setter
public abstract class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID")
    Long id;

    String name;
    int price;
    int stockQuantity;

    @ManyToMany(mappedBy = "items")
    List<CategoryEntity> categoryEntities;

    public void removeStock(int count) throws Exception {
        if(this.stockQuantity - count < 0) throw new Exception("재고 부족");
        this.stockQuantity -=count;
    }


    public void addStock(int count){
        this.stockQuantity += count;
    }
}
