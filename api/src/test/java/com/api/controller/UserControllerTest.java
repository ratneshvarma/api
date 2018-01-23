package com.api.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.api.ResponseData;
import com.api.entity.User;
import com.api.service.UserServiceImpl;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private UserServiceImpl userService;
//
//	@Test
//	public void allUsers() throws Exception {
//		String content_sc = "application/json";
//		List<User> users = new ArrayList<>();
//		users.add(new User());
//
//		when(userService.findAllUser()).thenReturn(users);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users")
//				.accept(MediaType.APPLICATION_JSON)
//				.content(content_sc);
//		MvcResult result = mvc.perform(requestBuilder).andReturn();
//		assertEquals(result.getResponse().getStatus(), 200);
//		assertEquals(result.getResponse().getContentType(), "application/json;charset=UTF-8");
//		
//	when(userService.findAllUser()).thenReturn(new ArrayList<User>());
//	 requestBuilder = MockMvcRequestBuilders.get("/api/users")
//				.accept(MediaType.APPLICATION_JSON)
//				.content(content_sc);
//	result = mvc.perform(requestBuilder).andReturn();
//	Gson gson = new Gson();
//	ResponseData responseData = gson.fromJson(result.getResponse().getContentAsString(), ResponseData.class);
//	assertEquals(responseData.getCode().intValue(), 404);
//	assertEquals(result.getResponse().getContentType(), "application/json;charset=UTF-8");
//
//	}
//	
//	@Test
//	public void getUserById() throws Exception{
//		String content_sc = "application/json";
//		User user = new User();
//		String id="2";
//		
//		when(userService.findUserById(anyLong())).thenReturn(user);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users/"+id)
//				.accept(MediaType.APPLICATION_JSON)
//				.content(content_sc);
//		MvcResult result = mvc.perform(requestBuilder).andReturn();
//		assertEquals(result.getResponse().getStatus(), 200);
//		assertEquals(result.getResponse().getContentType(), "application/json;charset=UTF-8");
//		
//		when(userService.findUserById(anyLong())).thenReturn(null);
//		 requestBuilder = MockMvcRequestBuilders.get("/api/users/"+id)
//				.accept(MediaType.APPLICATION_JSON)
//				.content(content_sc);
//		 result = mvc.perform(requestBuilder).andReturn();
//		Gson gson = new Gson();
//		ResponseData responseData = gson.fromJson(result.getResponse().getContentAsString(), ResponseData.class);
//		assertEquals(responseData.getCode().intValue(), 404);
//		assertEquals(result.getResponse().getContentType(), "application/json;charset=UTF-8");
//
//	}
	
	@Test
	public void addUser() throws Exception{
		
		String content_sc = "{" + 
				"          " + 
				"            \"firstName\": \"Om\"," + 
				"            \"lastName\": \"Kumar\"," + 
				"            \"age\": 20," + 
				"            \"address\": {" + 
				"               \"street\": \"m/2 ggndelhi\"," + 
				"                \"city\": \"delhi\"," + 
				"                \"state\": \"delhi\"," + 
				"                \"country\": \"india\"" + 
				"            }" + 
				"        }";
	//	String content_sc="{}";
		User user = new User();
		when(userService.addUser(user)).thenReturn(user);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/users/")
				.accept(MediaType.APPLICATION_JSON)
				.content(content_sc)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		
		Gson gson = new Gson();
		ResponseData responseData = gson.fromJson(result.getResponse().getContentAsString(), ResponseData.class);
		assertEquals(responseData.getCode().intValue(), 201);
		assertEquals(result.getResponse().getContentType(), "application/json;charset=UTF-8");
		
		when(userService.addUser(user)).thenReturn(null);
		 requestBuilder = MockMvcRequestBuilders.post("/api/users/")
				.accept(MediaType.APPLICATION_JSON)
				.content(content_sc)
				.contentType(MediaType.APPLICATION_JSON);
		result = mvc.perform(requestBuilder).andReturn();
		responseData = gson.fromJson(result.getResponse().getContentAsString(), ResponseData.class);
		assertEquals(responseData.getCode().intValue(), 400);
		assertEquals(result.getResponse().getContentType(), "application/json;charset=UTF-8");
		
	}

}
