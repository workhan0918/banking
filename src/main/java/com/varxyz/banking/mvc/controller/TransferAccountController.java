package com.varxyz.banking.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.Customer;
import com.varxyz.banking.mvc.service.AccountService;
import com.varxyz.banking.mvc.service.AccountServiceImpl;

@Controller("transferAccountController")
public class TransferAccountController {
	AccountService service = new AccountServiceImpl();
	
	// Post Redirect Get PRG 방식
	
	@GetMapping("/controller/transfer_account")
	public String transferForm(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("userIdSession");
		
		List<Account> accList = new ArrayList<Account>();
		
		accList = service.selectAccountById(userId);
		model.addAttribute("accList", accList);
		return "transfer/transfer";
	}
	
	@PostMapping("/controller/transfer_account")
	public String transfer(RedirectAttributes redirect, HttpServletRequest request, Model model) {
		
		if ( request.getParameter("myAccount").trim().isEmpty() || 
				request.getParameter("passwd").trim().isEmpty() ||
				request.getParameter("transferAccount").trim().isEmpty() ||
				request.getParameter("amount").trim().isEmpty()) {
			model.addAttribute("msg", "공백 문자는 입력이 불가능합니다.");
			return "alert/alert";
		}else if (Integer.valueOf(request.getParameter("amount")) <= 0) {
			model.addAttribute("msg", "0원이하로 입금 하실 수 없습니다.");
			return "alert/alert";
		}
		
		Account myAccount = new Account();
		Account transferAccount = new Account();
		
		Customer cus = new Customer();
		cus.setPasswd(request.getParameter("passwd"));
		
		myAccount.setAccountNum(request.getParameter("myAccount"));
		myAccount.setCustomer(cus);
		
		transferAccount.setAccountNum(request.getParameter("transferAccount"));
		
		double amount = 0;
		
		try {
			amount = Long.parseLong(request.getParameter("amount"));
		}catch (NumberFormatException e) {
			model.addAttribute("msg", "문자는 입력하실 수 없습니다.");
			return "alert/alert";
		}
		
		boolean transferRs = service.transfer(myAccount, transferAccount, amount);
		
		if(!transferRs) {
			model.addAttribute("msg", "올바른 값을 입력해주세요.");
			return "alert/alert";
		}
		
		Account accNum = new Account();
		
		
		accNum = service.selectAccountByAccNum(request.getParameter("myAccount"));
		
		redirect.addAttribute("accNum", accNum.getBalance());
		redirect.addAttribute("transferAccNum", transferAccount.getAccountNum());
		redirect.addAttribute("amount", amount);
		
		AccountService.context.close();
		
		return "redirect:/transfer/success_transfer";
	}
	
	@GetMapping("transfer/success_transfer")
	public String transferRedi(@RequestParam(value = "accNum") double accNum,
							   @RequestParam(value = "transferAccNum") String transferAccNum,
							   @RequestParam(value = "amount") double amount, Model model) {
		
		model.addAttribute("accNum", accNum);
		model.addAttribute("transferAccNum", transferAccNum);
		model.addAttribute("amount", amount);
		
		return "/transfer/success_transfer";
	}
	
}
