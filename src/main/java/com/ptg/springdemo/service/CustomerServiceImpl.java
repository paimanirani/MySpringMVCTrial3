package com.ptg.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptg.springdemo.dao.CustomerDAO;
import com.ptg.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);

	}

	@Override
	@Transactional
	public Customer getCustomer(int customerID) {
		return customerDAO.getCustomer(customerID);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerID) {
		customerDAO.deleteCustomer(customerID);
	}

}
