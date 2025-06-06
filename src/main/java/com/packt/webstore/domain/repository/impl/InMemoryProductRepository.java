package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.packt.webstore.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> listOfProducts = new ArrayList<Product>();

    @Override
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }

    public InMemoryProductRepository() {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }

    @Override
    public Product getProductById(String productId) {
        Product productById = null;
        for(Product product : listOfProducts) {
            if(product!=null && product.getProductId()!=null
                    &&product.getProductId().equals(productId)){
                productById = product;
                break;
            }
        }
        if(productById == null){
            throw new ProductNotFoundException("No products found withthe product id: "+ productId);
        }
        return productById;
    }
    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<Product>();
        for(Product product: listOfProducts) {
            if(category.equalsIgnoreCase(product.getCategory())){
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();
        Set<String> criterias = filterParams.keySet();
        if(criterias.contains("brand")) {
            for(String brandName: filterParams.get("brand")) {
                for(Product product: listOfProducts) {
                    if(brandName.equalsIgnoreCase(product.getManufacturer())){
                        productsByBrand.add(product);
                    }
                }
            }
        }
        if(criterias.contains("category")) {
            for(String category: filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<Product>();
        for(Product product: listOfProducts) {
            if(manufacturer.equalsIgnoreCase(product.getManufacturer())){
                productsByManufacturer.add(product);
            }
        }
        return productsByManufacturer;

    }

    @Override
    public List<Product> getProductsByPriceFilter(Map<String, Object> priceMap) {
        List<Product> productsByPriceFilter = new ArrayList<Product>();
        Set<String> keySet = priceMap.keySet();

        boolean hasLow = keySet.contains("low");
        boolean hasHigh = keySet.contains("high");

        if (hasLow || hasHigh) {
            BigDecimal low = hasLow ? convertToBigDecimal(priceMap.get("low")) : null;
            BigDecimal high = hasHigh ? convertToBigDecimal(priceMap.get("high")) : null;

            for (Product product : listOfProducts) {
                BigDecimal unitPrice = product.getUnitPrice();
                boolean meetsLow = !hasLow || (unitPrice.compareTo(low) >= 0);
                boolean meetsHigh = !hasHigh || (unitPrice.compareTo(high) <= 0);

                if (meetsLow && meetsHigh) {
                    productsByPriceFilter.add(product);
                }
            }
        }

        return productsByPriceFilter;
    }

    @Override
    public Set<Product> getProductsByMultiFilter(String productCategory, Map<String, Object> priceMap, String manufacturer) {
        Set<Product> filteredByCategory = new HashSet<>(getProductsByCategory(productCategory));
        Set<Product> filteredByPrice = new HashSet<>(getProductsByPriceFilter(priceMap));
        Set<Product> filteredByManufacturer = new HashSet<>(getProductsByManufacturer(manufacturer));

        filteredByCategory.retainAll(filteredByPrice);
        filteredByCategory.retainAll(filteredByManufacturer);

        return filteredByCategory;
    }

    private BigDecimal convertToBigDecimal(Object value) {
        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        } else if (value instanceof String) {
            return new BigDecimal((String) value);
        } else {
            throw new IllegalArgumentException("Invalid type for price filter: " + value);
        }
    }
}
