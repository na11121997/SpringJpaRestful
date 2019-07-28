package com.cg.banking.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.InvalidAmountException;

@ControllerAdvice
public class BankingExceptionAspect {
		private Account account;
	
	@ExceptionHandler(InvalidAmountException.class)
	public ModelAndView handledInvalidAmountException(Exception e) {
		ModelAndView modelAndView=new ModelAndView("registrationPage","errorMessage",e.getMessage());
		 modelAndView.addObject("account", new Account());
		 return modelAndView;
		}
	@ExceptionHandler(AccountNotFoundException.class)
	public ModelAndView handledAccountNotFoundException1(Exception e) {
		ModelAndView modelAndView=new ModelAndView("depositMoneyPage","errorMessage",e.getMessage());
		 modelAndView.addObject("account", new Account());
		 return modelAndView;
		}
	/*@ExceptionHandler(AccountNotFoundException.class)
	public ModelAndView handledAccountNotFoundException2(Exception e) {
		ModelAndView modelAndView=new ModelAndView("withdrawMoneyPage","errorMessage",e.getMessage());
		 modelAndView.addObject("account", new Account());
		 return modelAndView;
		}
	/*@ExceptionHandler(AccountNotFoundException.class)
	public ModelAndView handledAccountNotFoundException3(Exception e) {
		ModelAndView modelAndView=new ModelAndView("fundTransferPage","errorMessage",e.getMessage());
		 modelAndView.addObject("account", new Account());
		 return modelAndView;
		}*/
	@ModelAttribute
	public Account getAccount(){
		account=new Account();
		return account;
	}
}