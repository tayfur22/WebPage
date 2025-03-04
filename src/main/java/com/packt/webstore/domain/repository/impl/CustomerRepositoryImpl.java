package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer1;
import com.packt.webstore.domain.repository.CustomerRepository1;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository1 {
    private Map<String, Customer1> customerDataStore = new HashMap<>();

    @Override
    public void saveCustomer(Customer1 customer) {
        customerDataStore.put(customer.getCustomerId(), customer);
    }

    @Override
    public Customer1 getCustomer(String customerId) {
        return customerDataStore.get(customerId);
    }

    @Override
    public Boolean isCustomerExist(String customerId) {
        return customerDataStore.containsKey(customerId);
    }
}
