package com.capgemini.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.capgemini.model.ParkingFloor;
import com.capgemini.model.ParkingPremise;
import com.capgemini.model.ParkingSlots;

public interface ParkingDao {
	public boolean checkAvailability(Date date, String time) throws SQLException;
	public boolean bookParkingSlot(ParkingSlots slot) throws SQLException;
	public boolean cancelParkingSlotBooking(ParkingSlots slot) throws SQLException;
	
	public List<ParkingSlots> readAllParkingSlotsByPremise(ParkingPremise parkingPremise);
	public List<ParkingSlots> readAllParkingSlotsByFloor(ParkingFloor parkingFloor);
	public ParkingSlots readParkingSlotsById(long parkingSlotId) throws SQLException;

}
