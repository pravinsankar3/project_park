package com.psap.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.model.ParkingSlots;
import com.psap.repository.ParkingSlotsRepository;
import com.psap.service.ParkingService;


@RestController
@RequestMapping("ParkingSlot/Parking")
public class ParkingController {
		
		@Autowired
		ParkingService service;
		
		@GetMapping("{parkingId}")
		public ResponseEntity<ParkingSlots> getSlot(@PathVariable("parkingId") int parkingId) {
			
			Optional<ParkingSlots> ParkingSlots = service.getParkingSlotsById(parkingId);
			
		    return new ResponseEntity<ParkingSlots>(ParkingSlots.get(),HttpStatus.OK);
}
		
		@PostMapping("{parkingId}")
		public ResponseEntity<ParkingSlots> bookparking(@RequestBody ParkingSlots slot){
			
			Optional <ParkingSlots> ParkingSlots = service.bookParkingSlot(slot.)
			
			return new ResponseEntity <ParkingSlots> (ParkingSlots.get(),HttpStatus.OK);
		}
		
//		@PostMapping("{parkingId}")
//		public ResponseEntity<ParkingSlots> bookparking(@PathVariable("parkingId") long parkingId ){
//			
//			Optional<ParkingSlots> ParkingSlots = service.bookParkingSlot(parkingId);
//			
//			return new ResponseEntity<ParkingSlots>(ParkingSlots.get(),HttpStatus.OK);
//		}
}