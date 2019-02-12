package com.invillia.acme.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invillia.acme.exceptionhandler.StatusInvalidException;
import com.invillia.acme.filter.OrderFilter;
import com.invillia.acme.model.Order;
import com.invillia.acme.model.Status;
import com.invillia.acme.repository.OrderRepository;

@Service
public class OrderService extends AbstractService<Order, OrderRepository>{

	
	public List<Order> search(OrderFilter orderFilter)  {
		try {
			Status status = Status.valueOf(orderFilter.getStatus());
			orderFilter.setStatusEnum(status);
		} catch(Exception ex) {
			throw new StatusInvalidException("Status informado invalida");
		}
		 
		
		return repository.search(orderFilter);
	}
}
