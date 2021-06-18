package com.psap;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import com.psap.model.Address;
import com.psap.model.Login;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.Role;
import com.psap.model.User;
import com.psap.repository.LoginRepository;
import com.psap.repository.ParkingFloorRepository;
import com.psap.repository.ParkingPremiseRepository;
import com.psap.repository.UserRepository;

@SpringBootTest
class Admin {

	@Autowired
	LoginRepository lr;
	@Autowired
	UserRepository ur;
	@Autowired
	ParkingPremiseRepository pp;
	@Autowired
	ParkingFloorRepository pf;
		
	@Test
	void contextLoads() {
	}
		
	@Test
	@Order(1)
		public void loginTest() {
		Login l = new Login(); 
		l.setLoginId("123A");
		l.setPassword("hello123");
		l.setRole(new Role(1, "Programmer", "Software Programmer"));
		l.setUser(new User(1234, "Vijay", "Janarthanan", "hello12@gmail.com", "1234567890", true));
		lr.save(l);
		assertNotNull(lr.findById(l.getLoginId()));
	}
	
	public void blockUserTest() {
		Optional<User> u=ur.findById((long) 1234);
		if(u!=null) {				
		ur.deleteById((long) 1234);
		}
		Optional<User> u1=ur.findById((long) 1234);			
		assertThat(u1==null);
	}
	
	public void addParkingPremiseTest() {
		ParkingPremise pps = new ParkingPremise();
		pps.setParkingPremiseId(1);
		pps.setParkingPremiseName("New Age Parking Solutions");
		pps.setPremiseAddress(new Address(101, "Vellore", "Tamil Nadu", "632001"));
		pp.save(pps);
		assertNotNull(pp.findById(pps.getParkingPremiseId()));
	}
	
	public void getParkingPremiseByIdTest() {
		ParkingPremise pps  =	pp.findByParkingPremiseId(1);		
		assertEquals(pps.getParkingPremiseId(),1);								
	}
	
	public void getParkingPremiseByNameTest() {
		ParkingPremise pps = pp.findByParkingPremiseName("New Age Parking Solutions");
		assertEquals(pps.getParkingPremiseName(),"New Age Parking Solutions");
	}
	
	public void getAllParkingPremiseTest() {
		List<ParkingPremise> pps  = pp.findAll();			
	    assertThat(pps.size()>=0);
	}
	
	public void modifyParkingPremiseTest() {
		
	}
	
	public void removeParkingPremiseTest() {
		ParkingPremise pps = pp.findByParkingPremiseId(1);
		if(pps!=null) {				
		pp.deleteById(1);
		}
		Optional<User> u1=ur.findById((long) 1);			
		assertThat(u1==null);
	}
	
	public void addParkingFloorTest() {
		ParkingFloor pfs = new ParkingFloor();
		pfs.setParkingFloorId(1);
		pfs.setNumberOfParkingSlots(100);
		pfs.setFloorNumber("1A");
		pfs.setParkingPremise(new ParkingPremise(100, "Parking Venture", new Address(11, "Chennai", "Tamil Nadu", "600017"), 5));;
		pf.save(pfs);
		assertNotNull(pf.findById(pfs.getParkingFloorId()));
	}
	
	
}
		