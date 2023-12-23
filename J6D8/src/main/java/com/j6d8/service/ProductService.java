package com.j6d8.service;

import java.util.List;
import java.util.Optional;

import com.j6d8.entity.Product;

public interface ProductService {

    List<Product> findAll();

    List<Product> findByCategoryId(String cid);

    Product findById(Integer id);

    Product create(Product product);

    Product update(Product product);

    void delete(Integer id);


}
