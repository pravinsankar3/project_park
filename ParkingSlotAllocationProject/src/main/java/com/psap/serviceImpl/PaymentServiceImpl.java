package com.psap.serviceImpl;

import java.util.Date;
import java.util.List;

import com.psap.exceptions.NoSuchPaymentFoundException;
import com.psap.exceptions.PaymentFailureException;
import com.psap.model.Payment;
import com.psap.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {

	@Override
	public boolean parkingBookingPayment(Payment payment) throws PaymentFailureException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Payment findPaymentById(long paymentId) throws NoSuchPaymentFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findPaymentByDate(Date paymentDate) throws NoSuchPaymentFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
