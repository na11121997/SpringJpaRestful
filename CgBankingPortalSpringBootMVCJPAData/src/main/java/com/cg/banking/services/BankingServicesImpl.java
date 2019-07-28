package com.cg.banking.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.TransactionDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

@Component("bankServices")
public class BankingServicesImpl implements BankingServices{
	@Autowired
	private AccountDAO accountDao ;
	@Autowired
	private TransactionDAO transDao;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public Account openAccount(Account account)throws InvalidAmountException {
		//	throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		if(account.getAccountBalance()<500) {
			throw new InvalidAmountException("Amount should be more than 500");
		}
		int pin = (int)( Math.random()*10000 ) ;
		account.setPinNumber(pin);
		String accountStatus = "ACTIVE";
		account.setAccountStatus(accountStatus);
		HashMap<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();
		account.setTransactions(transactions);
		
		account = accountDao.save(account);
		return account;
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account accnt = getAccountDetails(accountNo);
		if(accnt.getAccountStatus().equalsIgnoreCase("ACTIVE")) {
			float newAmount = accnt.getAccountBalance() + amount;
			accnt.setAccountBalance(newAmount);
			accountDao.save(accnt);
			Transaction transaction = new Transaction(amount,"DEPOSITED",accnt);
			transDao.save(transaction);
			return newAmount;
		}else {
			throw new AccountBlockedException("This account has been blocked");
		}
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account accnt = getAccountDetails(accountNo);
		if(accnt.getAccountStatus().equalsIgnoreCase("ACTIVE")){
			for(int i =0;i<2;i++) {
				if(accnt.getPinNumber()==pinNumber) {
					float newAmount = accnt.getAccountBalance() - amount ; 
					if(newAmount < 500) 
						throw new InsufficientAmountException("Balance cannot go below 500");
					else {
						accnt.setAccountBalance(newAmount);
						Transaction transaction = new  Transaction(amount, "WITHDRAW" , accnt);
						transDao.save(transaction);
					accountDao.save(accnt);
					}
					return newAmount;
				}
				else {
					System.out.println("Your PIN is wrong . Kindly enter again");
					pinNumber = sc.nextInt();
				}
			}
			accnt.setAccountStatus("BLOCKED");
			throw new InvalidPinNumberException("YOUR PIN WAS WRONG MULTIPLE TIMES ");
		}else 
			throw new AccountBlockedException("YOUR ACCOUNT HAS BEEN BLOCKED");
	
}

	
	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
			float newAmount = withdrawAmount(accountNoFrom, transferAmount, pinNumber);
			depositAmount(accountNoTo, transferAmount);
			if(newAmount!=0.00f) 
				return true;
			else
				return false;
		
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		return accountDao.findById( accountNo).orElseThrow
				(()-> new AccountNotFoundException("account detial not found"+accountNo));
		//return null;
	}

	@Override
	public List<Account> getAllAccoutDetails() throws BankingServicesDownException {
		return accountDao.findAll();
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo) throws BankingServicesDownException, AccountNotFoundException {		
		Account account= getAccountDetails(accountNo);
		List<Transaction> transactions=new ArrayList<>(account.getTransactions().values());
	    return transactions;
	}

	@Override
	public String accountString(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Account accnt = getAccountDetails(accountNo);
		return "Account [pinNumber=" + accnt.getPinNumber() + ", accountType=" + accnt.getAccountType() + ", accountStatus=" + accnt.getAccountStatus()
				+ ", accountBalance=" + accnt.getAccountBalance() + ", accountNo=" + accnt.getAccountNo()
				+  "]";
	}
	
}
