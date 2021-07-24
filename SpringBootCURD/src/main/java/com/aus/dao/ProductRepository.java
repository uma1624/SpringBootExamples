package com.aus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aus.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
