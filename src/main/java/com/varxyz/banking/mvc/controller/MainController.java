package com.varxyz.banking.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.service.AccountService;
import com.varxyz.banking.mvc.service.AccountServiceImpl;

@Controller
public class MainController {
	
	@GetMapping("/controller/main")
	public String mainGet(HttpServletRequest request, HttpSession session, Model model, RedirectAttributes redi) {
		// 세션 정보 검사
		if (session.getAttribute("userIdSession") == null) {
			model.addAttribute("msg", "로그인후 이용하실 수 있습니다.");
			model.addAttribute("url", "/banking/controller/login");
			return "alert/alert";
		}else {
			session.getAttribute("userIdSession");
			System.out.println(session.getAttribute("userIdSession"));
			
			AccountService accountService = new AccountServiceImpl();
			List<Account> accList = new ArrayList<>(); 
			accList = accountService.selectAccountById((String)session.getAttribute("userIdSession"));
			model.addAttribute("accList",accList);
			AccountService.context.close();
			return "main/main_page";
		}
	}
}
