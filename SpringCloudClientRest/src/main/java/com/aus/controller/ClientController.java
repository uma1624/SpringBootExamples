package com.aus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/name/{uname}")
  public String invokeService(@PathVariable String uname) {
		String url = "http://DisplayService/payment/display/"+uname;
	  return restTemplate.getForObject(url, String.class);
  }
}
