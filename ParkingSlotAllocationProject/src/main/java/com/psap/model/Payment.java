package com.psap.model;

import java.util.Date;

public class Payment {
	private long paymentId;
	private PaymentType type;
	private Date paymentDateTime;
	private double amountPaid;
	private PaymentStatus status;
	
	// Constructors, Getter & Setter method
	
	
	public Payment(long paymentId, PaymentType type, Date paymentDateTime, double amountPaid, PaymentStatus status) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.paymentDateTime = paymentDateTime;
		this.amountPaid = amountPaid;
		this.status = status;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public Date getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(Date paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
	
	
	
}
