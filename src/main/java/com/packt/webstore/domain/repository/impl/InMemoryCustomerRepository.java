package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customers;

    public InMemoryCustomerRepository() {
        customers = new ArrayList<Customer>();

        customers.add(new Customer(1, "John Doe", "123 Main St", 5));
        customers.add(new Customer(2, "Jane Smith", "456 Oak St", 3));

    }

    @Override
    public List<Customer>  getAllCustomers() {
        return customers;
    }
}
