package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
