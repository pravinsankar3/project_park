package com.psap.serviceImpl;

import java.util.List;

import com.psap.exceptions.DuplicateVehicleException;
import com.psap.exceptions.NoSuchVehicleException;
import com.psap.model.Vehicle;
import com.psap.service.VehicleService;

public class VehicleServiceImpl implements VehicleService{

	@Override
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> findAllVehiclesByUserId(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vehicle modifyVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

}
