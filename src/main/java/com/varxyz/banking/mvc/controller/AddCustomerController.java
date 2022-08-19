package com.varxyz.banking.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.mvc.domain.Customer;
import com.varxyz.banking.mvc.service.CustomerService;
import com.varxyz.banking.mvc.service.CustomerServiceImpl;

@Controller("controller.addCustomerController")
public class AddCustomerController {
	
	@GetMapping("/controller/add_customer")
	public String addCustomerForm() {
		return "adds/add_customer";
	}
	
	@PostMapping("/controller/add_customer")
	public String addCustomer(Customer customer, Model model) {
		CustomerService service = new CustomerServiceImpl();

		model.addAttribute(customer);
		service.addCustomer(customer);
		
		CustomerService.context.close();
		return "adds/add_success_customer";
	}
	
}
