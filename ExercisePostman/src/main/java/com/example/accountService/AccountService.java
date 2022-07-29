package com.example.accountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.account.Repo.AccountRepo;
import com.example.model.Account;

@Service
public class AccountService {
private AccountRepo repo;
	
	public AccountService(AccountRepo repo) {
	super();
	this.repo = repo;
}
public Account addAccout(Account a1) {
	return this.repo.save(a1);
}
	public List<Account> readAccount(){
		return this.repo.findAll();
	}
	
	
	
	public Account updateAccount(long id, Account a2) {
		Optional<Account> myTempAccount=this.repo.findById(id);
		Account existing=myTempAccount.get();
		existing.setAccountNumber(a2.getAccountNumber());
		existing.setName(a2.getName());
		return this.repo.save(existing);
		
	}
	public boolean deleteAccount (long id) {
		this.repo.deleteById(id);
		boolean exists=this.repo.existsById(id);
		return !exists;
	}
}

