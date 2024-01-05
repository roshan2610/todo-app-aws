package com.example.ToDoApp.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespondMsg {

	private String msg;
	
	private Boolean success;
	
	private HttpStatus status;

	
}
