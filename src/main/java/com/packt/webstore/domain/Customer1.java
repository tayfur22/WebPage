package com.packt.webstore.domain;

import java.io.Serializable;
import java.util.Objects;

public class Customer1 implements Serializable {
    private static final long serialVersionUID = 2284040482222162898L;

    private String customerId;
    private String name;
    private Address billingAddress;
    private String phoneNumber;

    public Customer1() {
        this.billingAddress = new Address();
    }

    public Customer1(String customerId, String name) {
        this();
        this.customerId = customerId;
        this.name = name;
    }

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer1 customer = (Customer1) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
