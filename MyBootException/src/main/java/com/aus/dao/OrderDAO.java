package com.aus.dao;

import com.aus.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer> {

   // Order findByName(String ordername);
}
