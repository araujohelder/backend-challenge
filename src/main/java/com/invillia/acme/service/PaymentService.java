package com.invillia.acme.service;

import org.springframework.stereotype.Service;

import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.PaymentRepository;

@Service
public class PaymentService extends AbstractService<Payment, PaymentRepository> {
	
}
