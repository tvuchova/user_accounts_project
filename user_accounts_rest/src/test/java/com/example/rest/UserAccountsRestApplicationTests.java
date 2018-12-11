package com.example.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.example.rest.accounts.controller.AccountController;
import com.example.rest.accounts.entity.Account;
import com.example.rest.accounts.service.AccountsHardcodedService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserAccountsRestApplicationTests extends JsonObjectConvertorTest {
	protected MockMvc mockMvc;

	@Mock
	private AccountsHardcodedService accountService;

	@InjectMocks
	private AccountController accountController;

	@Before
	public void init() {
		accountController = mock(AccountController.class);
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(this.accountController).build();
	}

	@Test
	public void getAccountsList() throws Exception {
		String uri = "/accounts";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Account[] accountlist = super.mapFromJson(content, Account[].class);
	}

	@Test
	public void createAccount() throws Exception {
		String uri = "/accounts";
		Account account = new Account();
		account.setFirstName("Ivan");
		account.setLastName("Ginger");
		account.setEmail("ssss@dd.com");
		account.setBirthDate(new Date());

		String inputJson = super.mapToJson(account);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
	}

	@Test
	public void updateAccount() throws Exception {
		String uri = "/accounts/2";
		Account account = new Account();
		account.setFirstName("Lemon");

		String inputJson = super.mapToJson(account);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
	}

	@Test
	public void deleteAccount() throws Exception {
		String uri = "/accounts/2";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
	}
}
