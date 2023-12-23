package com.j6d8.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j6d8.entity.Category;
import com.j6d8.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
    @Autowired
    CategoryService categorytService;

    @GetMapping()
    public List<Category> getAll() {
        return categorytService.findAll();
    }
}
