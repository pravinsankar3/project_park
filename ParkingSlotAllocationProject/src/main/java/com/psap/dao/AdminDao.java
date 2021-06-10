package com.psap.dao;

import java.sql.SQLException;
import java.util.List;

import com.psap.model.Login;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.User;

public interface AdminDao {
	public boolean login(Login login) throws SQLException;

	public boolean blockUser(User user) throws SQLException;

	// Parking Premise
	public boolean createParkingPremise(ParkingPremise parkingPremise) throws SQLException;
	public ParkingPremise readParkingPremiseById(long parkingPremiseId) throws SQLException;
	public List<ParkingPremise> readParkingPremiseByName(String premiseName) throws SQLException;
	public List<ParkingPremise> readAllParkingPremises();
	public ParkingPremise updateParkingPremise(ParkingPremise parkingPremise);
	public boolean deleteParkingPremise(int parkingPremiseId) throws SQLException;

	// Parking Floor
	public boolean createParkingFloor(ParkingFloor parkingFloor) throws SQLException;
	public ParkingFloor readParkingFloorById(long parkingFloorId) throws SQLException;
	public List<ParkingFloor> readParkingFloorByNumber(long parkingPremiseId, String floorNumber) throws SQLException;
	public List<ParkingFloor> readAllParkingFloors(long parkingPremiseId);
	public ParkingFloor updateParkingCapacity(ParkingFloor parkingFloor);
	public boolean deleteParkingFloor(long parkingFloorId) throws SQLException;
}