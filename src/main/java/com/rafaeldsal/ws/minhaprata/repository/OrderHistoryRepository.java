package com.rafaeldsal.ws.minhaprata.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaeldsal.ws.minhaprata.model.OrderHistory;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

  Page<OrderHistory> findAllHistoryByOrderId(Long orderId, Pageable pageable);
  
}