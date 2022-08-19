package com.varxyz.banking.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.mvc.domain.Account;

@Repository("accountDao")
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 계좌추가
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(userId, accountNum, "
				+ " balance, interestRate, overAmount, accType) "
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		System.out.println(account.getCustomer().getUserId());
		jdbcTemplate.update(sql, account.getCustomer().getUserId(), account.getAccountNum(),
			 account.getBalance(), account.getInterestRate(), account.getOverAmount(), account.getAccountType());
	}
	
	// 아이디로 계좌 조회
	public List<Account> selectAccountById(String userId) {
		String sql = "SELECT * FROM Account WHERE userId = ?";
		return jdbcTemplate.query(sql, new AccountRowMapper(), userId);
	}
	
	// 계좌번호로 계좌 조회
	public Account selectAccountByAccNum(String accountNum) {
		String sql = "SELECT * FROM Account WHERE accountNum = ?";
		return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), accountNum);
	}
	
	// 이체 기능
	public boolean transfer(Account myAccount, Account transferAccount, double amount){
		String sql = "SELECT a.aid, a.accType, a.userId, a.accountNum, a.balance, a.regDate, c.passwd "
				+ " FROM Account a INNER JOIN Customer c "
				+ " ON a.userId = c.userId WHERE a.accountNum = ?";
		
		List<Account> accArr = new ArrayList<>();
		List<Account> accArr2 = new ArrayList<>();
		
		accArr = jdbcTemplate.query(sql, new TransferRowMapper(), myAccount.getAccountNum());
		accArr2 = jdbcTemplate.query(sql, new TransferRowMapper(), transferAccount.getAccountNum());

		
		if(accArr.get(0).getCustomer().getPasswd().equals(myAccount.getCustomer().getPasswd())) {
			System.out.println("비밀번호 일치");
			String changeAmountSQL = "UPDATE Account SET balance = ? WHERE accountNum = ?";
			
			if(accArr.get(0).getBalance() < amount) {
				return false;
			}
			myAccount.setBalance(accArr.get(0).getBalance() - amount);
			jdbcTemplate.update(changeAmountSQL, myAccount.getBalance(), myAccount.getAccountNum());
			
			try {
				transferAccount.setBalance(accArr2.get(0).getBalance() + amount);				
			}catch (IndexOutOfBoundsException e) {
				System.out.println("문자열 입력 오류발생");
				return false;
			}
			
			jdbcTemplate.update(changeAmountSQL, transferAccount.getBalance(), transferAccount.getAccountNum());
			
			System.out.println(amount + "원 입금 완료");
		}else {
			return false;
		}
		return true;
		

	}
}
