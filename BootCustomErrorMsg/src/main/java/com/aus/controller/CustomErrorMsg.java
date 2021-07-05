package com.aus.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorMsg implements ErrorController{
 public static final String  PATH = "/error";
	@GetMapping(path = PATH)
	public String errorMsg() {
		return "Request Resource not found";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
