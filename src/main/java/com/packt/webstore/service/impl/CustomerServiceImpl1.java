package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Customer1;
import com.packt.webstore.domain.repository.CustomerRepository1;
import com.packt.webstore.service.CustomerService1;

public class CustomerServiceImpl1 implements CustomerService1 {
    private CustomerRepository1 customerRepository;

    public void setCustomerRepository(CustomerRepository1 customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(Customer1 customer) {
        customerRepository.saveCustomer(customer);
    }

    @Override
    public Customer1 getCustomer(String customerId) {
        return customerRepository.getCustomer(customerId);
    }

    @Override
    public Boolean isCustomerExist(String customerId) {
        return customerRepository.isCustomerExist(customerId);
    }
}
