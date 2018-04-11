package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.AddressDto;
import com.api.dto.UserDto;
import com.api.entity.Address;
import com.api.entity.User;
import com.api.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
  
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User findUserById(long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	@Override
	public List<User> findAllUser() {
		List<User> user = userRepository.findAll();
		return user;
	}

	@Override
	public User addUser(User user) {
		User user1 = userRepository.save(user);
		return user1;
	}

	@Override
	public boolean deleteUser(long id) {
		userRepository.delete(id);
		return true;
	}

	@Override
	public User updateUser(User user) {
		User user1 = userRepository.save(user);
		return user1;
	}

	@Override
	public User userAssembler(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setAge(userDto.getAge());
		
		Address address = new Address();		
		address.setStreet(userDto.getAddressDto().getStreet());
		address.setCity(userDto.getAddressDto().getCity());
		address.setState(userDto.getAddressDto().getState());
		address.setCountry(userDto.getAddressDto().getCountry());
		user.setAddress(address);
		
		return user;
	}

	@Override
	public Boolean exist(long id) {
		Boolean exist = userRepository.exists(id);
		return exist;
	}

}
