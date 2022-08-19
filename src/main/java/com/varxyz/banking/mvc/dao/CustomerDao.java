package com.varxyz.banking.mvc.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.mvc.domain.Customer;

@Repository("customerDao")
public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 유저추가
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (userId, passwd, name, ssn, phone) "
				+ " VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, customer.getUserId(), customer.getPasswd(),
				customer.getName(), customer.getSsn(), customer.getPhone());
	}
	
	// 로그인 기능
	public boolean login(Customer customer) {
		boolean result = true;
		
		String sql = "SELECT userId, passwd FROM Customer WHERE userId = ?";
		Customer dbCustomer = new Customer();
		dbCustomer = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class),
												customer.getUserId());

		
		if (dbCustomer.getUserId().equals(customer.getUserId()) && 
				dbCustomer.getPasswd().equals(customer.getPasswd())) {
			return result;			
		}else {
			return !result;
		}
		
	}
	
}
