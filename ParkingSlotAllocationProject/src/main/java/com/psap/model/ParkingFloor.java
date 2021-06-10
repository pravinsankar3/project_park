package com.psap.model;

public class ParkingFloor {
	// should be auto-generated
	private int parkingFloorId;
	private ParkingPremise parkingPremise;
	private String floorNumber;
	private int numberOfParkingSlots;
	
	// Constructors, Getter & Setter method
	
	
	public ParkingFloor(int parkingFloorId, ParkingPremise parkingPremise, String floorNumber,
			int numberOfParkingSlots) {
		super();
		this.parkingFloorId = parkingFloorId;
		this.parkingPremise = parkingPremise;
		this.floorNumber = floorNumber;
		this.numberOfParkingSlots = numberOfParkingSlots;
	}

	public int getParkingFloorId() {
		return parkingFloorId;
	}

	public void setParkingFloorId(int parkingFloorId) {
		this.parkingFloorId = parkingFloorId;
	}

	public ParkingPremise getParkingPremise() {
		return parkingPremise;
	}

	public void setParkingPremise(ParkingPremise parkingPremise) {
		this.parkingPremise = parkingPremise;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getNumberOfParkingSlots() {
		return numberOfParkingSlots;
	}

	public void setNumberOfParkingSlots(int numberOfParkingSlots) {
		this.numberOfParkingSlots = numberOfParkingSlots;
	}
	
	
	
	
}
