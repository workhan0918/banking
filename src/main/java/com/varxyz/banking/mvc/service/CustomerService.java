package com.varxyz.banking.mvc.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.banking.mvc.dao.CustomerDao;
import com.varxyz.banking.mvc.data.BankingConfig;
import com.varxyz.banking.mvc.domain.Customer;

public interface CustomerService {
	AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(BankingConfig.class);
	
	CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
	
	public void addCustomer(Customer customer);

	public boolean login(Customer customer);
}
