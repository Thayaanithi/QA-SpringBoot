package com.example.accountService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.accountDTO.AccountDTO;
import com.example.accountRepo.AccountRepository;
import com.example.model.Account;

@Service
public class AccountService {
	private AccountRepository accountRepository;
    private ModelMapper mapper;
    public AccountService(AccountRepository accountRepository, ModelMapper mapper) {
        this.accountRepository = accountRepository;
        this.mapper = mapper;
    }
    private AccountDTO mapToDTO(Account account) {
        return mapper.map(account, AccountDTO.class);
    }
    public AccountDTO addAccount(Account account) {
        Account saved = accountRepository.save(account);
        return mapToDTO(saved);
    }
    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    
    
    public AccountDTO updateAccount(Long id, Account account) {
        Optional<Account> existingOptional = accountRepository.findById(id);
        Account existing = existingOptional.get();
        existing.setName(account.getName());
        existing.setAccountNumber(account.getAccountNumber());
        Account updated = accountRepository.save(existing);
        return mapToDTO(updated);
    }
    public boolean removeAccount(Long id) {
        accountRepository.deleteById(id);
        boolean exists = accountRepository.existsById(id);
        return !exists;
    }
    public List<Account> getAccountByName(String name) {
        return accountRepository.findAccountByName(name);    
}
}