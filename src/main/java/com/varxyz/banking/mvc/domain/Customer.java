package com.varxyz.banking.mvc.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
	private String userId;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private Date regDate;
	
	public Customer() {
		super();
	}
	
	public Customer(String userId) {
		this.userId = userId;
	}
	
}
