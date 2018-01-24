package com.api.error;

public class MessageDto {
	private String message;
	private MessageType messageType;
	
	public MessageDto(String message, MessageType messageType) {
		super();
		this.message = message;
		this.messageType = messageType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
}
