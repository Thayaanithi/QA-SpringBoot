package com.example.accountDTO;

public class AccountDTO {
private Long id;
private String name;
private String accountNumber;

public AccountDTO() {
	super();
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}




}