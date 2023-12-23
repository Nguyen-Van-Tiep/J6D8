package com.j6d8.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6d8.entity.Order;
import com.j6d8.entity.OrderDetail;
import com.j6d8.repository.OrderRepository;
import com.j6d8.repository.OrderDetailRepository;
import com.j6d8.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderRepository dao;

    @Autowired
    OrderDetailRepository ddao;

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData, Order.class);
        dao.save(order);// ném vào database
        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
        };
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
                .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
        ddao.saveAll(details);
        return order;
    }

    @Override
    public Object findByID(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {
        return dao.findByUsername(username);
    }

}
