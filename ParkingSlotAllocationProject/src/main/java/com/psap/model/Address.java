package com.psap.model;

public class Address {
	// should be auto-generated
	private int addressId;
	private String city;
	private String state;
	private String pin;
	
	// Constructors, Getter & Setter method
	
	
	public Address(int addressId, String city, String state, String pin) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
	
	
}
