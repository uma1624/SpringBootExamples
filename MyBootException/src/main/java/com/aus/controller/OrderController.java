package com.aus.controller;

import com.aus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("getPrice/{id}")
    public  String getAmount(@PathVariable Integer id){
       return "The Price of the product id  "+id+" and price is  "+orderService.getPrice(id);
    }
}
