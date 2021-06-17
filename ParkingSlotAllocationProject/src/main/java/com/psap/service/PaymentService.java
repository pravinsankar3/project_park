package com.psap.service;

import java.util.Date;
import java.util.List;

import com.psap.exceptions.NoSuchPaymentFoundException;
import com.psap.exceptions.PaymentFailureException;
import com.psap.model.Payment;

public interface PaymentService {
	public boolean parkingBookingPayment(Payment payment) throws PaymentFailureException;
	public Payment findPaymentById(long paymentId) throws NoSuchPaymentFoundException;
	public List<Payment> findPaymentByDate(Date paymentDate);
}
