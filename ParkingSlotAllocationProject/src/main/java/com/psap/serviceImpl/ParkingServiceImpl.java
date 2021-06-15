package com.psap.serviceImpl;

import java.util.Date;
import java.util.List;

import com.psap.exceptions.NoSuchParkingSlotException;
import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.ParkingSlots;
import com.psap.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {

	@Override
	public boolean checkAvailability(Date date, String time) throws ParkingSlotNotAvailableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bookParkingSlot(ParkingSlots slot) throws ParkingSlotNotAvailableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelParkingSlotBooking(ParkingSlots slot) throws NoSuchParkingSlotException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ParkingSlots> getAllParkingSlotsByPremise(ParkingPremise parkingPremise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkingSlots> getAllParkingSlotsByFloor(ParkingFloor parkingFloor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParkingSlots getParkingSlotsById(long parkingSlotId) throws NoSuchParkingSlotException {
		// TODO Auto-generated method stub
		return null;
	}

}
