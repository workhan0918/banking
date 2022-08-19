package com.varxyz.banking.mvc.service;


import com.varxyz.banking.mvc.domain.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	@Override
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
	}

	@Override
	public boolean login(Customer customer) {
		return dao.login(customer);
	}

}
