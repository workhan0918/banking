package com.varxyz.banking.mvc.service;

import java.util.List;

import com.varxyz.banking.mvc.domain.Account;

public class AccountServiceImpl implements AccountService {

	@Override
	public void addAccount(Account account) {
		dao.addAccount(account);
	}

	@Override
	public List<Account> selectAccountById(String userId) {
		return dao.selectAccountById(userId);
	}

	@Override
	public boolean transfer(Account myAccount, Account depositAccount, double amount) {
		return dao.transfer(myAccount, depositAccount, amount);
	}

	@Override
	public Account selectAccountByAccNum(String accNum) {
		return dao.selectAccountByAccNum(accNum);
	}



}
