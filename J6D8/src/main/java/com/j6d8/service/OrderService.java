package com.j6d8.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.j6d8.entity.Order;

public interface OrderService {

    Order create(JsonNode orderData);

    Object findByID(Long id);

    List<Order> findByUsername(String username);

}
