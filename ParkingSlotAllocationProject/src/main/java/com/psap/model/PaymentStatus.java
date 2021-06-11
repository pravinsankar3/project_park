package com.psap.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PaymentStatus")
public enum PaymentStatus {
	PENDING, CONFIRMED, CANCELLED
}
