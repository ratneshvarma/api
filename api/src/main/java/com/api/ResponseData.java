package com.api;

public class ResponseData {
private Integer code;
private String message;
private Object response;


public ResponseData(Integer code, String message, Object response) {
	super();
	this.code = code;
	this.message = message;
	this.response = response;
}

public Integer getCode() {
	return code;
}
public void setCode(Integer code) {
	this.code = code;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Object getResponse() {
	return response;
}
public void setResponse(Object response) {
	this.response = response;
}

}
