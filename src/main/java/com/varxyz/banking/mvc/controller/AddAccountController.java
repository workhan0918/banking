package com.varxyz.banking.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.Customer;
import com.varxyz.banking.mvc.service.AccountService;
import com.varxyz.banking.mvc.service.AccountServiceImpl;

@Controller("controller.addAccountControler")
public class AddAccountController {
	
	@GetMapping("/controller/add_account")
	public String addAccountForm() {
		return "adds/add_account";
	}
	
	@PostMapping("/controller/add_account")
	public String addAccount(HttpSession session, Account account, Model model) {
		AccountService service = new AccountServiceImpl();
		
		Customer c = new Customer();
		c.setUserId((String)session.getAttribute("userIdSession"));
		account.setCustomer(c);
		
		// 계좌번호 랜덤 생성 로직
		String numStr = String.valueOf((int) (Math.random() * 1000000000));
	      StringBuilder sb = new StringBuilder();
	      sb.append(numStr.substring(0, 3));
	      sb.append("-");
	      sb.append(numStr.substring(3, 5));
	      sb.append("-");
	      sb.append(numStr.substring(5));
	    System.out.println(sb.toString());
	    
	    account.setAccountNum(sb.toString());
		model.addAttribute(account);
		service.addAccount(account);
		
		AccountService.context.close();
		return "adds/add_success_account";
	}
}
