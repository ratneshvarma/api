package com.api.service;

import java.util.List;

import com.api.dto.UserDto;
import com.api.entity.User;

public interface IUserService {
	User findUserById(long id);
	List<User> findAllUser();
	User addUser(User user);
	boolean deleteUser(long id);
	User updateUser(User user);
	User userAssembler(UserDto userDto);
	Boolean exist(long id);
	
}
