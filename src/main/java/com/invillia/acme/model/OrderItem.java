package com.invillia.acme.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

	@Id
	@SequenceGenerator(name = "tb_order_item_seq", sequenceName = "tb_order_item_seq", allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_order_item_seq")
	private Long id;
	
	private String description;
	private BigDecimal price;
	private Integer quantity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
