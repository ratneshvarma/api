package com.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.ResponseData;
import com.api.dto.UserDto;
import com.api.entity.User;
import com.api.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseData allUsers() {
		List<User> list = (List<User>) userService.findAllUser();
		if (!list.isEmpty()) {
			ResponseData responseData = new ResponseData(HttpStatus.OK.value(), "Success", list);
			return responseData;
		} else {
			ResponseData responseData = new ResponseData(HttpStatus.NOT_FOUND.value(), "Not Found", list);
			return responseData;
		}
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseData getUserById(@PathVariable("id") int id) {
		User user = userService.findUserById(id);
		System.out.println("sdsadfsgf: " + user);
		if (user != null) {
			ResponseData responseData = new ResponseData(HttpStatus.OK.value(), "Success", user);
			return responseData;
		} else {
			ResponseData responseData = new ResponseData(HttpStatus.NOT_FOUND.value(), "Not Found", null);
			return responseData;
		}
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseData addUser(@Valid  @RequestBody UserDto userDto) {
		if (userDto != null && userDto.getFirstName() != null) {
			User user = userService.addUser(userService.userAssembler(userDto));
			ResponseData responseData = new ResponseData(HttpStatus.CREATED.value(), "User added", user);
			return responseData;
		} else {
			System.out.println("test2===========");
			ResponseData responseData = new ResponseData(HttpStatus.BAD_REQUEST.value(), "Invalid User", null);
			return responseData;
		}
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public ResponseData updateUser(@Valid @RequestBody UserDto userDto) {
		Boolean exist = userService.exist(userDto.getId());
		User user = null;// userService.findUserById(userDto.getId());
		if (exist) {
			user = userService.userAssembler(userDto);
			user.setId(userDto.getId());
			System.out.println("test1===========");
			user = userService.addUser(user);
			user.setId(userDto.getId());
			ResponseData responseData = new ResponseData(HttpStatus.ACCEPTED.value(), "User Updated", user);
			return responseData;
		} else {
			System.out.println("test2===========");
			user = userService.addUser(userService.userAssembler(userDto));
			ResponseData responseData = new ResponseData(HttpStatus.CREATED.value(), "User added", user);
			return responseData;
		}
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseData deleteUser(@PathVariable("id") int id) {
		Boolean exist = userService.exist(id);
		User user = userService.findUserById(id);
		if (exist) {
			userService.deleteUser(id);
			ResponseData responseData = new ResponseData(HttpStatus.ACCEPTED.value(), "User deleted", user);
			return responseData;
		} else {
			ResponseData responseData = new ResponseData(HttpStatus.NOT_FOUND.value(), "Not Found", null);
			return responseData;
		}
	}

}
