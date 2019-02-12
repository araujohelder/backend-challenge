package com.invillia.acme.filter;

import com.invillia.acme.model.Status;

public class OrderFilter {

	private String status;
	private Status statusEnum;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Status getStatusEnum() {
		return statusEnum;
	}

	public void setStatusEnum(Status statusEnum) {
		this.statusEnum = statusEnum;
	}

}
