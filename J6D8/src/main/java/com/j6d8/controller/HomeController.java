package com.j6d8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j6d8.entity.Account;
import com.j6d8.entity.Product;
import com.j6d8.repository.AccountRepository;
import com.j6d8.repository.ProductRepository;

@Controller
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping({"/", "/home/index"})
    public String home() {
        return "redirect:/product/list";
    }

    @RequestMapping({"/admin", "/admin/home/index"})
    public String admin() {
        return "redirect:/assets/admin/index.html";
    }

    @GetMapping("/api/account")
    public Product api() {
        Product list = productRepository.getById(1005);
        return list;
    }
}
