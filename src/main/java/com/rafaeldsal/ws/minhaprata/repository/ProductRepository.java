package com.rafaeldsal.ws.minhaprata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaeldsal.ws.minhaprata.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
