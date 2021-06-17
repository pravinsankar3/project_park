package com.psap.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.psap.exceptions.NoSuchPaymentFoundException;
import com.psap.exceptions.PaymentFailureException;
import com.psap.model.Payment;
import com.psap.service.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	PaymentService service;
	
	@PutMapping
	public ResponseEntity<?> parkingBookingPayment(Payment payment) throws PaymentFailureException {
		service.parkingBookingPayment(payment);
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
		
	@GetMapping("{paymentId}")
	public Payment fetchAllPaymentById(long paymentId) throws NoSuchPaymentFoundException {
		return service.findPaymentById(paymentId);
	}
	
	@GetMapping("{paymentDate}")
	public List<Payment> fetchAllPaymentByDate(Date paymentDate) throws NoSuchPaymentFoundException{
		return service.findPaymentByDate(paymentDate);
	}
	
}
