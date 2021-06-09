package com.capgemini.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.model.Vehicle;

public interface VehicleDao {
	public boolean createUsersVehicle(Vehicle vehicle) throws SQLException;
	public Vehicle readVehicleByVehicleNumber(String vehicleNumber, int userId) throws SQLException;
	public List<Vehicle> readAllVehiclesByUserId(int ownerId);
	public boolean deleteVehicleByVehicleNumber(String vehicleNumber, int userId) throws SQLException;
	public Vehicle updateVehicle(Vehicle vehicle);

}
