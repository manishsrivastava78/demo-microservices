package com.example.demo.model.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "{\"message\":\"Employee does not exist\"}")
public class NotFound extends RuntimeException{

}
