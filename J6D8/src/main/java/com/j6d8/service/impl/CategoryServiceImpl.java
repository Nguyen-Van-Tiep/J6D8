package com.j6d8.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6d8.entity.Category;
import com.j6d8.repository.CategoryRepository;
import com.j6d8.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository cdao;

    @Override
    public List<Category> findAll() {
        return cdao.findAll();
    }

}
