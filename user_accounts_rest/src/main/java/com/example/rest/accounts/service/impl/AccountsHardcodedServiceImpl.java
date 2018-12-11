package com.example.rest.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.rest.accounts.entity.Account;
import com.example.rest.accounts.repository.AccountRepository;
import com.example.rest.accounts.service.AccountsHardcodedService;
import com.example.rest.accounts.service.NextSequenceService;

@Service
public class AccountsHardcodedServiceImpl implements AccountsHardcodedService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private NextSequenceService nextSequenceService;

  public List<Account> findAll() {
    return accountRepository.findAll();
  }

  public void deleteById(Long id) {
    accountRepository.deleteById(id);
  }

  public Account save(Account account) {

    if (account.getId() == -1 || account.getId() == 0) {
      account.setId(nextSequenceService.getNextSequence("customSequences"));
      accountRepository.save(account);
    } else {
      accountRepository.save(account);
    }
    return account;
  }

  public Account findById(Long id) {
    return accountRepository.findById(id).get();
  }
}
