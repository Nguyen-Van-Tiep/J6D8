package com.j6d8.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6d8.entity.Product;
import com.j6d8.repository.ProductRepository;
import com.j6d8.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository pdao;

    @Override
    public List<Product> findAll() {
        return pdao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return pdao.findById(id).get();
    }

    @Override
    public List<Product> findByCategoryId(String cid) {
        return pdao.finByCategoryId(cid);
    }

    @Override
    public Product create(Product product) {
        return pdao.save(product);
    }

    @Override
    public Product update(Product product) {
        return pdao.save(product);
    }

    @Override
    public void delete(Integer id) {
        pdao.deleteById(id);
    }
}
