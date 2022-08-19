package com.varxyz.banking.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.Customer;
import com.varxyz.banking.mvc.service.AccountService;
import com.varxyz.banking.mvc.service.AccountServiceImpl;
import com.varxyz.banking.mvc.service.CustomerService;
import com.varxyz.banking.mvc.service.CustomerServiceImpl;

@Controller("loginAccountController")
public class LoginAccountController {
	
	@GetMapping("/controller/login")
	public String loginForm(HttpSession session) {
		// login 주소 접속시 세션 값 모두 삭제
		session.invalidate();
		return "login/login";
	}
	
	@PostMapping("/controller/login")
	public String loginAccount(HttpServletRequest request, Customer customer, Model model, HttpSession session) {
		session = request.getSession();
		CustomerService Cusservice = new CustomerServiceImpl();
		
		// 로그인 유효성 검사
		try {
			boolean value = Cusservice.login(customer);	
			if(!value) {
				model.addAttribute("msg", "로그인 정보가 일치하지 않습니다.");
				model.addAttribute("url", "/banking/controller/login");
				return "alert/alert";
			}
		} catch (EmptyResultDataAccessException e) {
			model.addAttribute("msg", "로그인 정보가 일치하지 않습니다.");
			model.addAttribute("url", "/banking/controller/login");
			return "alert/alert";
		}finally {			
			CustomerService.context.close();
		}
		
		// 세션 정보 전달
		session.setAttribute("userIdSession", customer.getUserId());
		
		return "redirect:/controller/main";
	}
	
}
