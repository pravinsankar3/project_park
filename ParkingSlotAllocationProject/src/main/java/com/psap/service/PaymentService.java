package com.psap.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import com.psap.exceptions.NoSuchPaymentFoundException;
import com.psap.exceptions.PaymentFailureException;
import com.psap.model.Payment;

@Service
public interface PaymentService {
	public boolean parkingBookingPayment(Payment payment) throws PaymentFailureException;
	public Payment findPaymentById(long paymentId) throws NoSuchPaymentFoundException;
	public List<Payment> findPaymentByDate(Date paymentDate) throws NoSuchPaymentFoundException;
}
