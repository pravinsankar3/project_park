package com.psap.service;

import java.util.Date;
import java.util.List;

import com.psap.exceptions.NoSuchParkingSlotException;
import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.ParkingSlots;

public interface ParkingService {
	public boolean checkAvailability(Date date, String time) throws ParkingSlotNotAvailableException;
	public boolean bookParkingSlot(ParkingSlots slot) throws ParkingSlotNotAvailableException;
	public boolean cancelParkingSlotBooking(ParkingSlots slot) throws NoSuchParkingSlotException;
	
	public List<ParkingSlots> getAllParkingSlotsByPremise(ParkingPremise parkingPremise);
	public List<ParkingSlots> getAllParkingSlotsByFloor(ParkingFloor parkingFloor);
	public ParkingSlots getParkingSlotsById(long parkingSlotId) throws NoSuchParkingSlotException;
	
}
