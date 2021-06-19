package com.psap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psap.exceptions.DuplicateParkingFloorException;
import com.psap.exceptions.InvalidLoginCredintialException;
import com.psap.exceptions.NoSuchParkingFloorException;
import com.psap.exceptions.NoSuchUserException;
import com.psap.model.Login;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.User;
import com.psap.service.AdminService;
import com.psap.service.ParkingService;
import com.psap.service.UserService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	UserService uservice;
	@Autowired
	ParkingService pservice;
	@Autowired
	AdminService aservice;

	// Get all parking floors
	@GetMapping("allpfloor/{parkingPremiseId}")
	public ResponseEntity<List<ParkingFloor>> getAllParkingFloors(@PathVariable ("parkingPremiseId") long parkingPremiseId) {
		List<ParkingFloor> pf = aservice.getAllParkingFloors(parkingPremiseId);
		return new ResponseEntity<List<ParkingFloor>>(pf, HttpStatus.OK);
	}

	// Add Parking Floor
	@PostMapping("addpfloor")
	public ResponseEntity<String> addParkingFloor(@RequestBody ParkingFloor parkingFloor) throws DuplicateParkingFloorException {
		if (!aservice.addParkingFloor(parkingFloor))
			throw new  DuplicateParkingFloorException("Parking floor already exists");
			else
			return new ResponseEntity<String>("Parking Floor Added", HttpStatus.OK);
	}

	

	}