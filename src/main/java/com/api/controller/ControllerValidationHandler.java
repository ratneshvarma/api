package com.api.controller;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.api.error.MessageDto;
import com.api.error.MessageType;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class ControllerValidationHandler {
  @Autowired
  private MessageSource msgSource;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public MessageDto processValidationError(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    FieldError error = result.getFieldError();

    return processFieldError(error);
  }

  private MessageDto processFieldError(FieldError error) {
    MessageDto message = null;
    if (error != null) {
      Locale currentLocale = LocaleContextHolder.getLocale();
      String msg = msgSource.getMessage(error.getDefaultMessage(), null, currentLocale);
      message = new MessageDto(msg, MessageType.ERROR);
    }
    return message;
  }
}