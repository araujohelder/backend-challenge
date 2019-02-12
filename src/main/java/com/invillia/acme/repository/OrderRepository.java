package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.model.Order;
import com.invillia.acme.repository.order.OrderRepositoryQuery;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryQuery {

}
