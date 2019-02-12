package com.invillia.acme.service;

import org.springframework.stereotype.Service;

import com.invillia.acme.model.OrderItem;
import com.invillia.acme.repository.OrderItemRepository;

@Service
public class OrderItemService extends AbstractService<OrderItem, OrderItemRepository> {
	
}
