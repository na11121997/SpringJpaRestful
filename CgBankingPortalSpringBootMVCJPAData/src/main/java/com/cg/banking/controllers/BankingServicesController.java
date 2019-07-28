package com.cg.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.services.BankingServices;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAmountException ;
import com.cg.banking.exceptions.InvalidPinNumberException;
@Controller
public class BankingServicesController {
    @Autowired
    BankingServices bankingServices;
	
	@RequestMapping("/openAccount")
	public ModelAndView registerAssociate(@ModelAttribute Account account)throws InvalidAmountException {
		account=bankingServices.openAccount(account);
		return new ModelAndView("registrationPage","account", account);
	}
	
	@RequestMapping("/depositMoney1")
	public ModelAndView depositMoney(@RequestParam int accountNo, float accountBalance)throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		float updatedBalance=bankingServices.depositAmount(accountNo,accountBalance);
		return new ModelAndView("depositMoneyPage","updatedBalance", updatedBalance);
	}
	@RequestMapping("/withdrawMoney1")
	public ModelAndView withrawMoney(@RequestParam int accountNo, float accountBalance,int pinNumber)throws InsufficientAmountException,AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		float updatedBalance=bankingServices.withdrawAmount(accountNo,accountBalance,pinNumber);
		return new ModelAndView("withdrawMoneyPage","updatedBalance", updatedBalance);
	}
	@RequestMapping("/fundTransfer1")
	public ModelAndView fundTransfer(@RequestParam int accountNoTo, float accountBalance,int pinNumber, int accountNoFrom)throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
	BankingServicesDownException, AccountBlockedException {
		boolean fundTransferStatus=bankingServices.fundTransfer(accountNoTo,accountNoFrom,accountBalance,pinNumber);
		return new ModelAndView("fundTransferPage","fundTransferStatus", fundTransferStatus);
	}
	@RequestMapping("/accountDetailsPage1")
	public ModelAndView accountDetails(@RequestParam int accountNo)throws AccountNotFoundException, BankingServicesDownException {
		Account account=bankingServices.getAccountDetails(accountNo);
		return new ModelAndView("accountDetailsPage","account", account);
	}
	@RequestMapping("/accountTransactions1")
	public ModelAndView accountTransactions(@RequestParam int accountNo)throws BankingServicesDownException, AccountNotFoundException {
		 List<Transaction> transactions=bankingServices.getAccountAllTransaction(accountNo);
		return new ModelAndView("accountTransactionsPage","transactions", transactions);
	}
	@RequestMapping("/allAccountDetailsPage1")
	public ModelAndView AllaccountDetails() throws BankingServicesDownException  {
		List<Account> accounts=bankingServices.getAllAccoutDetails();
		return new ModelAndView("allAccountDetailsPage","accounts",accounts);
	}
}



