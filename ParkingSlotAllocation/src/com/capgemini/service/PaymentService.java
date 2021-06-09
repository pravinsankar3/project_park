package com.capgemini.service;

import java.util.Date;
import java.util.List;

import com.capgemini.exceptions.NoSuchPaymentFoundException;
import com.capgemini.exceptions.PaymentFailureException;
import com.capgemini.model.Payment;

public interface PaymentService {
	public boolean parkingBookingPayment(Payment payment) throws PaymentFailureException;
	public Payment findPaymentById(long paymentId) throws NoSuchPaymentFoundException;
	public List<Payment> findPaymentByDate(Date paymentDate) throws NoSuchPaymentFoundException;
}
