package com.invillia.acme.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.filter.OrderFilter;
import com.invillia.acme.model.Order;
import com.invillia.acme.service.OrderService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/orders")
@Api(value = "order")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@PutMapping("/{id}")
	public ResponseEntity<Order>update(@PathVariable Long id, @Validated @RequestBody Order order) {
		Order orderSave = orderService.update(id, order);
		return ResponseEntity.ok().body(orderSave);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id)  {
		Order orderReturned = orderService.findByid(id);
		return orderReturned != null ? ResponseEntity.ok(orderReturned) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> search(OrderFilter orderFilter)   {
		List<Order> orders = orderService.search(orderFilter);
		return orders != null ? ResponseEntity.ok(orders) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Order> save(@Valid @RequestBody Order order, HttpServletResponse response) {
		Order orderCreated =  orderService.save(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderCreated);
	}
}
