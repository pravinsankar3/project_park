package com.psap.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psap.exceptions.NoSuchParkingSlotException;
import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.ParkingSlots;
import com.psap.service.ParkingService;

@RestController
@RequestMapping("ParkingSlot/Parking")
public class ParkingController {

	@Autowired
	ParkingService service;
	ParkingFloor fs;

	@GetMapping("{parkingId}")
	public ResponseEntity<ParkingSlots> getSlot(@PathVariable("parkingId") int parkingId)
			throws NoSuchParkingSlotException {

		Optional<ParkingSlots> ParkingSlots = service.getParkingSlotsById(parkingId);

		return new ResponseEntity<ParkingSlots>(ParkingSlots.get(), HttpStatus.OK);
	}

	@PostMapping("{parkingId}")
	public ResponseEntity<String> bookparking(@PathVariable("parkingId") @RequestBody ParkingSlots slot)
			throws ParkingSlotNotAvailableException {
		if (!service.bookParkingSlot(slot) == false) {
			throw new ParkingSlotNotAvailableException("Booking slots are not available");
		}
		service.bookParkingSlot(slot);
		return new ResponseEntity<String>("parkingSlot booked", HttpStatus.OK);
	}

	@GetMapping("/checkavail")
	public boolean checkAvailability(Date date, String time) throws ParkingSlotNotAvailableException {
		if (service.checkAvailability(date, time)) {
			boolean avail = service.checkAvailability(date, time);
			return avail;
		}
		return false;

	}

	@DeleteMapping("/cancel")
	public boolean cancelParkingSlotBooking(@RequestBody ParkingSlots slot) throws NoSuchParkingSlotException {
		if (service.cancelParkingSlotBooking(slot)) {
			boolean cancel = service.cancelParkingSlotBooking(slot);
			return cancel;
		}
		return false;

	}

//	@GetMapping("allpp")
//	public ResponseEntity<?> getAllParkingSlotsByPremise(ParkingPremise parkingPremise) {
//		List<ParkingSlots> ls = service.getAllParkingSlotsByPremise(parkingPremise);
//		
//	
//	}

	@GetMapping("{pslots}")
	public Optional<ParkingSlots> getParkingSlotsById(@PathVariable("pslots") @RequestBody long parkingSlotId)
			throws NoSuchParkingSlotException {
		Optional<ParkingSlots> ps = service.getParkingSlotsById(parkingSlotId);
		return ps;
	}

}