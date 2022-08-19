package com.varxyz.banking.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.Customer;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setAid(rs.getLong("aid"));
		account.setCustomer(new Customer (rs.getString("userid")));
		account.setAccountNum(rs.getString("accountNum"));
		account.setAccountType(rs.getString("accType"));
		account.setBalance(rs.getDouble("balance"));
		account.setRegDate(rs.getTimestamp("regDate"));
		
		return account;
	}

}
