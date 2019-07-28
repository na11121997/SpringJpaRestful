package com.cg.banking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.banking.beans.Account;
@Controller
public class URIController {

	private Account account;
	@RequestMapping(value= {"/","index"})
	public String getIndexPage(){
		return "indexPage";
	}
	
	@RequestMapping("/registration")
	public String getRegistrationPage(){
		return "registrationPage";
	}
	@RequestMapping("/depositMoney")
	public String getDepositMoneyPage(){
		return "depositMoneyPage";
	}
	@RequestMapping("/withdrawMoney")
	public String getWithrawMoneyPage(){
		return "withdrawMoneyPage";
	}
	@RequestMapping("/fundTransfer")
	public String getFundTransferPage(){
		return "fundTransferPage";
	}
	@RequestMapping("/accountDetails")
	public String getAccountDetailsPage(){
		return "accountDetailsPage";
	}
	@RequestMapping("/accountTransactions")
	public String getAccountTransactionsPage(){
		return "accountTransactionsPage";
	}
	@RequestMapping("/allAccountDetails")
	public String getAllAccountDetails(){
		return "allAccountDetailsPage";
	}
	@ModelAttribute
	public Account getAccount(){
		account=new Account();
		return account;
	}
}
