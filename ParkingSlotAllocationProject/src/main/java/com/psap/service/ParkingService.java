package com.psap.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.psap.exceptions.NoSuchParkingSlotException;
import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.ParkingSlots;

@Service
public interface ParkingService {
	public boolean checkAvailability(Date date, String time) throws ParkingSlotNotAvailableException;
	public boolean bookParkingSlot(ParkingSlots slot) throws ParkingSlotNotAvailableException;
	public boolean cancelParkingSlotBooking(ParkingSlots slot) throws NoSuchParkingSlotException;
	
	public List<ParkingPremise> getAllParkingSlotsByPremise(ParkingPremise parkingPremise);
	public Optional<ParkingSlots> getParkingSlotsById(long parkingSlotId);
	
	
}
