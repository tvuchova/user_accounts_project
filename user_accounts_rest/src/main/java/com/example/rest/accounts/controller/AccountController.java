package com.example.rest.accounts.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.accounts.entity.Account;
import com.example.rest.accounts.service.AccountsHardcodedService;
import com.example.rest.accounts.service.impl.AccountsHardcodedServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountController {

  @Autowired
  private AccountsHardcodedService accountService;

  @GetMapping("/accounts")
  public List<Account> getAllAccounts() {
    return accountService.findAll();
  }

  @GetMapping("/accounts/{id}")
  public Account getAccount(@PathVariable Long id) {
    return accountService.findById(id);
  }

  @PutMapping("/accounts/{id}")
  public ResponseEntity<Account> updateAccount(@PathVariable long id, @RequestBody Account account) {

    Account accountUpdated = accountService.save(account);

    return new ResponseEntity<Account>(accountUpdated, HttpStatus.OK);
  }

  @PostMapping("/accounts")
  public ResponseEntity<Void> createAccount(@RequestBody Account account) {

    Account createdAccount = accountService.save(account);

    // Location
    // Get current resource url
    /// {id}
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdAccount.getId())
        .toUri();

    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping("/accounts/{id}")
  public ResponseEntity<Void> deleteAccount(@PathVariable long id) {
    accountService.deleteById(id);
    return ResponseEntity.noContent().build();
    /*
     * Account account= accountService.deleteById(id); if (account!=null) { return
     * ResponseEntity.noContent().build(); } return
     * ResponseEntity.notFound().build();
     */

  }
}
