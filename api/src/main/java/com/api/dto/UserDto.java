package com.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

	private long id;
	private String firstName;
	private String lastName;
	private int age;
	@JsonProperty("address")
	private AddressDto addressDto;
	public UserDto() {
		
	}
	public UserDto(String firstName, String lastName, int age, AddressDto addressDto) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.addressDto = addressDto;
	}
	
	public AddressDto getAddressDto() {
		return addressDto;
	}
	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
