package com.invillia.acme.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.model.Payment;
import com.invillia.acme.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/payments")
@Api(value = "Payment")
public class PaymentResource {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Consultar por Id", notes = "/payments/2 por exemplo")
	public ResponseEntity<Payment> findById(@PathVariable Long id)  {
		Payment paymentReturned = paymentService.findByid(id);
		return paymentReturned != null ? ResponseEntity.ok(paymentReturned) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	@ApiOperation(value = "Consultar todos os payment. ")
	public ResponseEntity<List<Payment>> findAll()  {
		List<Payment> payment = paymentService.findAll();
		return payment != null ? ResponseEntity.ok(payment) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Editar payment. ")
	public ResponseEntity<Payment> save(@Valid @RequestBody Payment payment, HttpServletResponse response) {
		Payment paymentCreated =  paymentService.save(payment);
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentCreated);
	}
}
