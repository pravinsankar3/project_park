package com.capgemini.service;

import java.util.List;

import com.capgemini.exceptions.DuplicateVehicleException;
import com.capgemini.exceptions.NoSuchVehicleException;
import com.capgemini.model.Vehicle;

public interface VehicleService {
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException;
	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException;
	public List<Vehicle> findAllVehiclesByUserId(int ownerId);
	public boolean removeVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException;
	public Vehicle modifyVehicle(Vehicle vehicle);
}
