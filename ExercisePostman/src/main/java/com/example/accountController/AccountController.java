package com.example.accountController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.accountService.AccountService;
import com.example.model.Account;

@RestController
public class AccountController {
	private AccountService service;

	public AccountController(AccountService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Account create(@RequestBody Account a1) {
		return this.service.addAccout(a1);
	}

	@GetMapping("/read")
	public List<Account> read() {
		return this.service.readAccount();
	}

	@PutMapping("/update/{id}")
	public Account update(@PathVariable long id, @RequestBody Account a2) {
		return this.service.updateAccount(id, a2);

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		this.service.deleteAccount(id);
	}

	@GetMapping("/test")

	public String test() {
		return "Hi Account Holder";
	}
}
