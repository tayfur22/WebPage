package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.repository.OrderRepository;
import com.packt.webstore.service.CartService;
import com.packt.webstore.service.OrderService;
import com.packt.webstore.service.OrderService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl1 implements OrderService1 {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartService cartService;

    @Override
    public Long saveOrder(Order order) {
        Long orderId = orderRepository.saveOrder(order);
        cartService.delete(order.getCart().getCartId());
        return orderId;
    }
}
