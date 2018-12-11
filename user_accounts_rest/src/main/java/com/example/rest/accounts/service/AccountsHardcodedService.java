package com.example.rest.accounts.service;

import java.util.List;

import com.example.rest.accounts.entity.Account;

public interface AccountsHardcodedService {
  public List<Account> findAll();

  public void deleteById(Long id);

  public Account findById(Long id);

  public Account save(Account account);
}
