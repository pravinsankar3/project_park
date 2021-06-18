package com.psap.controller;

import java.util.List;

import org.slf4j.Logger;
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

import com.psap.exceptions.DuplicateVehicleException;
import com.psap.exceptions.NoSuchVehicleException;
import com.psap.model.Vehicle;
import com.psap.service.VehicleService;

@RestController
@RequestMapping("vehicles")
public class VehicleController {

	@Autowired
	VehicleService service;

	@PostMapping
	public ResponseEntity<?> addUsersVehicle(@RequestBody Vehicle vehicle) throws DuplicateVehicleException {
		// TODO Auto-generated method stub
		service.addUsersVehicle(vehicle);
		return new ResponseEntity<String>("", HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Vehicle> getAllVehicles() {
		return service.findAllVehiclesByUserId(1);
	}

	@GetMapping("{userId}")
	public List<Vehicle> fetchAllVehiclesByUserId(@PathVariable @RequestBody int userId) {
		return service.findAllVehiclesByUserId(userId);
	}

	@GetMapping("{vehicleNumber}/{userId}")
	public Vehicle fetchAllVehiclesByVehicleNumberAndUserId(@PathVariable @RequestBody String vehicleNumber,
			@PathVariable int userId) throws NoSuchVehicleException {
		return service.findVehicleByVehicleNumber(vehicleNumber, userId);
	}

	@DeleteMapping("{vehicleNumber}/{userId}")
	public ResponseEntity<?> removeUsersVehicle(@PathVariable @RequestBody String vehicleNumber,
			@PathVariable int userId) throws NoSuchVehicleException {
		service.removeVehicleByVehicleNumber(vehicleNumber, userId);
		return new ResponseEntity<String>("Vehicle removed successfully", HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> modifyUsersVehicle(@RequestBody Vehicle vehicle) {
		// TODO Auto-generated method stub
		service.modifyVehicle(vehicle);
		return new ResponseEntity<String>("Vehicle details updated", HttpStatus.OK);
	}

}
