package com.psap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.model.ParkingPremise;
import com.psap.model.ParkingSlots;
import com.psap.repository.AddressRepository;
import com.psap.repository.ParkingFloorRepository;
import com.psap.repository.ParkingPremiseRepository;
import com.psap.repository.ParkingSlotsRepository;
import com.psap.serviceImpl.ParkingServiceImpl;

@SpringBootTest
public class ParkingServiceImplTest {

	
	@Autowired
	ParkingPremiseRepository parkPremiseRepo;
	@Autowired
	ParkingFloorRepository parkFloorRepo;
	@Autowired
	ParkingSlotsRepository parkSlotsRepo;
	@Autowired
	AddressRepository addressRepo; 
	ParkingSlots slots;
	@Autowired
	ParkingServiceImpl psi;

	
	
	@Test
	public void checkAvailTest(){
		ParkingPremise p = new ParkingPremise();
		int i = psi.getAllParkingSlotsByPremise(p).size();
		int j = parkPremiseRepo.findAll().size();
		assertEquals( i, j);
	}
	
	@Test
	public void d() throws ParkingSlotNotAvailableException{
		Date date = new Date();
		boolean value = psi.checkAvailability(date, "01:00");
		assertEquals( true , value);
	}
	
}
