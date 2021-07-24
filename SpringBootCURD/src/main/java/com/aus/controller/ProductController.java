package com.aus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aus.model.Product;
import com.aus.service.ProductService;
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	
	private ProductService proService;
	@GetMapping("/")
	public String message() {
		return "Hello message ";
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Product pro) {
		proService.save(pro);
	}
	@GetMapping("/list")
	public List<Product> listallProducts() {
		return proService.listAll();
	}
}
