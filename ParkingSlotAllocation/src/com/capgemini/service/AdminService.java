package com.capgemini.service;

import java.util.List;

import com.capgemini.exceptions.DuplicateParkingFloorException;
import com.capgemini.exceptions.DuplicateParkingPremiseException;
import com.capgemini.exceptions.InvalidLoginCredintialException;
import com.capgemini.exceptions.NoSuchParkingFloorException;
import com.capgemini.exceptions.NoSuchParkingPremiseException;
import com.capgemini.exceptions.NoSuchUserException;
import com.capgemini.model.Login;
import com.capgemini.model.ParkingFloor;
import com.capgemini.model.ParkingPremise;
import com.capgemini.model.User;

public interface AdminService {
	public boolean login(Login login) throws InvalidLoginCredintialException;
	public boolean blockUser(User user) throws NoSuchUserException;
	
	// Parking Premise
	public boolean addParkingPremise(ParkingPremise parkingPremise) throws DuplicateParkingPremiseException;
	public ParkingPremise getParkingPremiseById(long parkingPremiseId) throws NoSuchParkingPremiseException;
	public List<ParkingPremise> getParkingPremiseByName(String premiseName) throws NoSuchParkingPremiseException;
	public List<ParkingPremise> getAllParkingPremises();
	public ParkingPremise modifyParkingPremise(ParkingPremise parkingPremise);
	public boolean removeParkingPremise(int parkingPremiseId) throws NoSuchParkingPremiseException;
	
	// Parking Floor
	public boolean addParkingFloor(ParkingFloor parkingFloor) throws DuplicateParkingFloorException;
	public ParkingFloor getParkingFloorById(long parkingFloorId) throws NoSuchParkingFloorException;
	public List<ParkingFloor> getParkingFloorByNumber(long parkingPremiseId, String floorNumber) throws NoSuchParkingFloorException;
	public List<ParkingFloor> getAllParkingFloors(long parkingPremiseId);
	public ParkingFloor modifyParkingCapacity(ParkingFloor parkingFloor);
	public boolean removeParkingFloor(long parkingFloorId) throws NoSuchParkingPremiseException;
	
}
