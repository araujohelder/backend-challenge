package com.invillia.acme.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_payment")
public class Payment {

	@Id
	@SequenceGenerator(name = "tb_payment_seq", sequenceName = "tb_payment_seq", allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_payment_seq")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name="cred_card_number")
	private Long credCardNumber;
	
	@Column(name="payment_date")
	@NotNull
	@NotBlank
	private LocalDate paymentDate;
	
	@OneToOne				
	@JoinColumn(name="id_order")
	@NotNull
	@NotBlank
	private	Order order;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Long getCredCardNumber() {
		return credCardNumber;
	}
	public void setCredCardNumber(Long credCardNumber) {
		this.credCardNumber = credCardNumber;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
