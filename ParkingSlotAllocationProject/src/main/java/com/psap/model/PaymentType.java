package com.psap.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PaymentType")
public enum PaymentType {
	CASH_TO_BE_PAID,
	CREDIT_CARD,
	DEBIT_CARD,
	INTERNET_BANKING
}
