package com.varxyz.banking.mvc.controller;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.Customer;
import com.varxyz.banking.mvc.service.AccountService;
import com.varxyz.banking.mvc.service.AccountServiceImpl;

@Controller("selectAccountController")
public class SelectAccountController {
	
	@GetMapping("/controller/select_account")
	public String selectAccountForm() {
		return "select/selectMyAccount";
	}
	
	@PostMapping("/controller/select_account")
	public String selectAccountById(HttpServletRequest request, Customer customer, Account account, Model model) {
		List<Account> accountArr = new ArrayList<>();
		
		AccountService service = new AccountServiceImpl();
		
		if( customer.getUserId() == null || customer.getUserId().trim().isEmpty()) {
			
			model.addAttribute("msg", "빈값은 입력 하실 수 없습니다.");
			return "alert/alert";
		}
		
		account.setCustomer(customer);
		accountArr = service.selectAccountById(account.getCustomer().getUserId());
		
		if (accountArr.isEmpty()) {
			model.addAttribute("msg", "존재하지 않는 사용자 입니다.");
			return "alert/alert";
		}
		
		model.addAttribute("accountArr", accountArr);
		
		AccountService.context.close();
		return "select/select_success_account";
	}
}
