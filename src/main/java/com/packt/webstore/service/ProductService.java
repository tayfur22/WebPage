package com.packt.webstore.service;

import com.packt.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {

    void addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(String productID);

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    List<Product> getProductsByManufacturer(String manufacturer);

    List<Product> getProductsByPriceFilter(Map<String, Object> priceMap);

    Set<Product> getProductsByMultiFilter(String productCategory, Map<String, Object> priceMap,
                                          String manufacturer);
}
