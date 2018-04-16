package com.ptg.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptg.springdemo.entity.Customer;
import com.ptg.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers = customerService.getCustomers();
		theModel.addAttribute("customers", customers);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model themodel) {
		themodel.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("updateCustomer")
	public String updateCustomer(Model theModel, @RequestParam("customerID") int customerID) {
		Customer customer = customerService.getCustomer(customerID);
		theModel.addAttribute("customer", customer);
		return "customer-form";
	}

	@GetMapping("deleteCustomer")
	public String deleteCustomer(@RequestParam("customerID") int customerID) {
		customerService.deleteCustomer(customerID);
		return "redirect:/customer/list";
	}
}
