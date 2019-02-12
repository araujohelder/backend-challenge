package com.invillia.acme.repository.order;

import java.util.List;

import com.invillia.acme.filter.OrderFilter;
import com.invillia.acme.model.Order;

public interface OrderRepositoryQuery {
	
	public List<Order> search(OrderFilter orderFilter);
	
}