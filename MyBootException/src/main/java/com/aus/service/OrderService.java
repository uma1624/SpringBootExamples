package com.aus.service;

import com.aus.dao.OrderDAO;
import com.aus.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDAO dao;

    @PostConstruct
    public void addOrder() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1, "dell", "laptop", 100));
        orderList.add(new Order(2, "lenovo", "mobile", 30));
        dao.saveAll(orderList);
    }


    public double getPrice(int  id) {
        Order order = dao.getById(id);
        return order.getAmount();
    }

}
