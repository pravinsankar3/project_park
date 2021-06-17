package com.psap.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psap.exceptions.NoSuchParkingSlotException;
import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.ParkingSlots;
import com.psap.repository.ParkingSlotsRepository;
import com.psap.service.ParkingService;

@RestController
@RequestMapping("/parkingslot")
public class ParkingSlotController {
	
	@Autowired
	ParkingSlotsRepository prepo;
	@Autowired	
	ParkingService service;
	
	
	public boolean checkAvailability(Date date, String time) throws ParkingSlotNotAvailableException{
		
		return false;
	}
	public boolean bookParkingSlot(ParkingSlots slot) throws ParkingSlotNotAvailableException{
		return false;
	}
	public boolean cancelParkingSlotBooking(ParkingSlots slot) throws NoSuchParkingSlotException{
		return false;
	}
	
	public List<ParkingSlots> getAllParkingSlotsByPremise(ParkingPremise parkingPremise){
		return ;
	}
	public List<ParkingSlots> getAllParkingSlotsByFloor(ParkingFloor parkingFloor){
		
	}
	public ParkingSlots getParkingSlotsById(long parkingSlotId) throws NoSuchParkingSlotException{
		
	}
}
