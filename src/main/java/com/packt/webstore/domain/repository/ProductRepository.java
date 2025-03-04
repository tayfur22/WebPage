package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.ProductNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {

    void addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(String productID) throws ProductNotFoundException;

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    List<Product> getProductsByManufacturer(String manufacturer);

    List<Product> getProductsByPriceFilter(Map<String, Object> priceMap);

    Set<Product> getProductsByMultiFilter(String productCategory, Map<String, Object> priceMap,
                                          String manufacturer);

}
