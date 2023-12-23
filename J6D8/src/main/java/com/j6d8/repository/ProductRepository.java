package com.j6d8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.j6d8.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("Select p FROM Product p WHERE p.category.id=?1")
    List<Product> finByCategoryId(String cid);

}
