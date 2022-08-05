package com.example.accountController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.accountDTO.AccountDTO;
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
	public AccountDTO create(@RequestBody Account a1) {
		
		return this.service.addAccount(a1);
	}

	@GetMapping("/read")
	public List<AccountDTO> read() {
		return this.service.getAllAccounts();
	}
				

	@PutMapping("/update/{id}")
	public AccountDTO update(@PathVariable Long id, @RequestBody Account a2) {
		return this.service.updateAccount(id, a2);

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		this.service.removeAccount(id);
	}

	@GetMapping("/test")

	public String test() {
		return "Hi Account Holder";
	}
}
