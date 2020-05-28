package com.example.demo.shop.repository;

import com.example.demo.shop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
