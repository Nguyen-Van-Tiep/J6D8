package com.j6d8.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j6d8.service.OrderService;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/order/checkout") //đến trang đặt hàng
    public String checkout() {
        return "order/checkout";
    }

    @RequestMapping("/order/list") //liệt kê tất cả đơn hàng đã đặt
    public String list(Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        model.addAttribute("orders", orderService.findByUsername(username));
        return "order/list";
    }

    @RequestMapping("/order/detail/{id}") //xem chi tiết đơn hàng đã đặt
    public String detail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("order", orderService.findByID(id));
        return "order/detail";
    }

}
