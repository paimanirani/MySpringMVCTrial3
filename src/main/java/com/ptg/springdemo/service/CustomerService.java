package com.ptg.springdemo.service;

import java.util.List;

import com.ptg.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerID);

	public void deleteCustomer(int customerID);
}
