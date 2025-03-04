package com.packt.webstore.service;

import com.packt.webstore.domain.Customer1;

public interface CustomerService1 {

    void saveCustomer(Customer1 customer);

    Customer1 getCustomer(String customerId);

    Boolean isCustomerExist(String customerId);
}
