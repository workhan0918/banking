package com.varxyz.banking.mvc.data;

import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.varxyz.banking.mvc.dao.AccountDao;
import com.varxyz.banking.mvc.dao.CustomerDao;

@Configuration
@ComponentScan(basePackageClasses = {CustomerDao.class, AccountDao.class})
public class BankingConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/banking?serverTimezone=Asia/Seoul");
		ds.setUsername("banking");
		ds.setPassword("banking");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setMaxIdle(10);
		return ds;
	}
	
}
