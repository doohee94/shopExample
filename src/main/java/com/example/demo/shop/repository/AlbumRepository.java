package com.example.demo.shop.repository;

import com.example.demo.shop.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlbumRepository extends JpaRepository<Album, Long> {
}
