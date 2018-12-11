package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;


@SpringBootApplication
public class UserAccountsRestApplication {
 
  public static void main(String[] args) {
    SpringApplication.run(UserAccountsRestApplication.class, args);
  }
}
