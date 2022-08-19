package com.varxyz.banking.mvc.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.banking.mvc.dao.AccountDao;
import com.varxyz.banking.mvc.data.BankingConfig;
import com.varxyz.banking.mvc.domain.Account;

public interface AccountService {
	AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(BankingConfig.class);
	
	AccountDao dao = context.getBean("accountDao", AccountDao.class);
	
	public void addAccount(Account account);
	
	public List<Account> selectAccountById(String userId);

	public boolean transfer(Account myAccount, Account depositAccount, double amount);

	public Account selectAccountByAccNum(String accNum);

}
