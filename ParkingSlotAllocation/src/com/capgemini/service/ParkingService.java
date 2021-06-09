package com.capgemini.service;

import java.util.Date;
import java.util.List;

import com.capgemini.exceptions.NoSuchParkingSlotException;
import com.capgemini.exceptions.ParkingSlotNotAvailableException;
import com.capgemini.model.ParkingFloor;
import com.capgemini.model.ParkingPremise;
import com.capgemini.model.ParkingSlots;

public interface ParkingService {
	public boolean checkAvailability(Date date, String time) throws ParkingSlotNotAvailableException;
	public boolean bookParkingSlot(ParkingSlots slot) throws ParkingSlotNotAvailableException;
	public boolean cancelParkingSlotBooking(ParkingSlots slot) throws NoSuchParkingSlotException;
	
	public List<ParkingSlots> getAllParkingSlotsByPremise(ParkingPremise parkingPremise);
	public List<ParkingSlots> getAllParkingSlotsByFloor(ParkingFloor parkingFloor);
	public ParkingSlots getParkingSlotsById(long parkingSlotId) throws NoSuchParkingSlotException;
	
}
