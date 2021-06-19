package com.psap.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psap.exceptions.NoSuchParkingSlotException;
import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.model.ParkingPremise;
import com.psap.model.ParkingSlots;
import com.psap.repository.AddressRepository;
import com.psap.repository.ParkingFloorRepository;
import com.psap.repository.ParkingPremiseRepository;
import com.psap.repository.ParkingSlotsRepository;
import com.psap.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	ParkingPremiseRepository parkPremiseRepo;
	@Autowired
	ParkingFloorRepository parkFloorRepo;
	@Autowired
	ParkingSlotsRepository parkSlotsRepo;
	@Autowired
	AddressRepository addressRepo;
	ParkingSlots slots;

//Check Slot availability 
	
	@Override
	public boolean checkAvailability(Date date, String time) throws ParkingSlotNotAvailableException {
		ParkingSlots p = parkSlotsRepo.findByParkingDateAndParkingTime(date, time);
		if (p != null)
			return false;
		return true;
	}

//Book Slot
	
	@Override
	public boolean bookParkingSlot(ParkingSlots slot) throws ParkingSlotNotAvailableException {
		Optional<ParkingSlots> p = parkSlotsRepo.findById(slot.getParkingSlotId());
		if (p.isPresent())
			throw new ParkingSlotNotAvailableException("Parking slot is occupied");
		parkSlotsRepo.save(slot);
		return true;
	}

	
//Cancel Slot
	
	@Override
	public boolean cancelParkingSlotBooking(ParkingSlots slot) throws NoSuchParkingSlotException {
		Optional<ParkingSlots> p = parkSlotsRepo.findById(slot.getParkingSlotId());
		if (!p.isPresent())
			throw new NoSuchParkingSlotException("Parking slot is not available");
		parkSlotsRepo.delete(slot);
		return true;
	}

//Display all Slot by Premise
	
	@Override
	public List<ParkingPremise> getAllParkingSlotsByPremise(ParkingPremise parkingPremise) {
		return parkPremiseRepo.findAll();
	}

//Display Slot by ID
	
	@Override
	public Optional<ParkingSlots> getParkingSlotsById(long parkingSlotId) {

		Optional<ParkingSlots> slot = parkSlotsRepo.findById(parkingSlotId);
		if (!slot.isPresent())
			throw new NoSuchParkingSlotException("Slot With Id " + parkingSlotId + " Not Found");
		return slot;
	}

}
