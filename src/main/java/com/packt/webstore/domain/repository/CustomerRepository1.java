package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Customer1;

public interface CustomerRepository1 {
    void saveCustomer(Customer1 customer);

    Customer1 getCustomer(String customerId);

    Boolean isCustomerExist(String customerId);
}
