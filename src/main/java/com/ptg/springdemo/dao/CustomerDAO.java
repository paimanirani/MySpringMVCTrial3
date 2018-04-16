package com.ptg.springdemo.dao;

import java.util.List;

import com.ptg.springdemo.entity.Customer;

public interface CustomerDAO {
public List<Customer> getCustomers();

public void saveCustomer(Customer customer);

public Customer getCustomer(int customerID);

public void deleteCustomer(int customerID);
}
