package com.varxyz.banking.mvc.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
	private long aid;
	private Customer customer;
	private String accountNum;
	private String accountType;
	private double balance;
	private double interestRate;
	private double overAmount;
	private Date regDate;
}
