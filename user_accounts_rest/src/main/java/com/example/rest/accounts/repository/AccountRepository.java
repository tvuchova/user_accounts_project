package com.example.rest.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.accounts.entity.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, Long> {

}
