package com.example.rest.welcome.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.welcome.entity.WelcomeBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WelcomeController {

  @GetMapping(path = "/hello-world")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping(path = "/welcome-bean")
  public WelcomeBean helloWorldBean() {
    return new WelcomeBean("Hello World - Changed");
  }

  @GetMapping(path = "/welcome/path-variable/{name}")
  public WelcomeBean helloWorldPathVariable(@PathVariable String name) {
    return new WelcomeBean(String.format("Hello , %s", name));
  }
}
