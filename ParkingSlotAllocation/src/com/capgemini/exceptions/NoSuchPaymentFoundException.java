package com.capgemini.exceptions;

public class NoSuchPaymentFoundException extends Exception {
	public NoSuchPaymentFoundException(String message) {
		super(message);
	}
}
