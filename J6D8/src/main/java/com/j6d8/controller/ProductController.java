package com.j6d8.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.j6d8.entity.Product;
import com.j6d8.service.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/product/list")
    public String list(Model model, @RequestParam("cid") Optional<String> cid) {
        if (cid.isPresent()) {
            List<Product> list = productService.findByCategoryId(cid.get());
            model.addAttribute("items", list);
        } else {
            List<Product> list = productService.findAll();// nhờ productService lấy ra toàn bộ product
            model.addAttribute("items", list);
        }

        return "product/list";
    }

    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Product item = productService.findById(id);
        System.out.println(item);
        model.addAttribute("item", item);
        return "product/detail";
    }
}
