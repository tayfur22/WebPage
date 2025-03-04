package com.packt.webstore.service.impl;

import com.packt.webstore.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int quantity) {
        try {
            Product productById = productRepository.getProductById(productId);

            if (productById.getUnitsInStock() < quantity) {
                throw new IllegalArgumentException("Out of Stock. Available Units in stock: " + productById.getUnitsInStock());
            }

            productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
        } catch (ProductNotFoundException e) {
            throw new IllegalArgumentException("Product with ID " + productId + " not found!", e);
        }
    }
}
