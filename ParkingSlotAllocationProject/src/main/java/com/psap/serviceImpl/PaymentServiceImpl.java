package com.psap.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.psap.exceptions.DuplicateParkingPremiseException;
import com.psap.exceptions.DuplicateVehicleException;
import com.psap.exceptions.NoSuchParkingPremiseException;
import com.psap.exceptions.NoSuchPaymentFoundException;
import com.psap.exceptions.NoSuchVehicleException;
import com.psap.exceptions.PaymentFailureException;
import com.psap.model.ParkingPremise;
import com.psap.model.Payment;
import com.psap.model.User;
import com.psap.model.Vehicle;
import com.psap.repository.PaymentRepository;
import com.psap.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository dao;
	
	@Override
	public boolean parkingBookingPayment(Payment payment) throws PaymentFailureException {
		// TODO Auto-generated method stub
		Optional<Payment> p= dao.findById(payment.getPaymentId()) ;
		if(p.isPresent())
			throw new PaymentFailureException("Payment Fail");
		dao.save(payment);
		return true;
	}

	@Override
	public Payment findPaymentById(long paymentId) throws NoSuchPaymentFoundException {
		// TODO Auto-generated method stub
		Optional<Payment> p= dao.findById(paymentId);
		if(p.isPresent())
			throw new NoSuchPaymentFoundException("No payment for this id");
		return p.get();
	}


	@Override
	public List<Payment> findPaymentByDate(Date paymentDate) {
		// TODO Auto-generated method stub
		
		List<Payment> paymentList = dao.findByPaymentDateTime(paymentDate);
		return paymentList;
	}

}
