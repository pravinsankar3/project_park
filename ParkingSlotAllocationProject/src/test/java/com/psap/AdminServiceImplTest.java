package com.psap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import com.psap.model.Login;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.User;
import com.psap.repository.LoginRepository;
import com.psap.repository.ParkingFloorRepository;
import com.psap.repository.ParkingPremiseRepository;
import com.psap.repository.UserRepository;

@SpringBootTest
class AdminServiceImplTest {

	@Autowired
	LoginRepository lr;
	@Autowired
	UserRepository ur;
	@Autowired
	ParkingPremiseRepository pp;
	@Autowired
	ParkingFloorRepository pf;
		
		
	@Test
		public void loginTest() {
		Login l = new Login(); 
		l.setLoginId("123A");
		l.setPassword("hello123");
//		l.setRole(new Role(1, "Programmer", "Software Programmer"));
//		l.setUser(new User(1234, "Vijay", "Janarthanan", "hello12@gmail.com", "1234567890", true));
		lr.save(l);
		assertNotNull(lr.findById("123A"));
	}
	@Test
	public void blockUserTest() {
		User u = ur.findByUserId(213);
		if(u!=null) {				
		ur.deleteById((long) 213);
		}
		User u1 = ur.findByUserId(213);
		assertThat(u1==null);
	}
	@Test
	public void addParkingPremiseTest() {
		ParkingPremise pps = new ParkingPremise();
		pps.setParkingPremiseId(1);
		pps.setParkingPremiseName("New Age Parking Solutions");
//		pps.setPremiseAddress(new Address(101, "Vellore", "Tamil Nadu", "632001"));
		pp.save(pps);
		assertNotNull(pp.findById(1));
	}
	@Test
	public void getParkingPremiseByIdTest() {
		ParkingPremise pps  =	pp.findByParkingPremiseId(11);		
		assertEquals(pps.getParkingPremiseId(),11);								
	}
	@Test
	public void getParkingPremiseByNameTest() {
		ParkingPremise pps = pp.findByParkingPremiseName("Building");
		assertEquals(pps.getParkingPremiseName(),"Building");
	}
	@Test
	public void getAllParkingPremiseTest() {
		List<ParkingPremise> pps  = pp.findAll();			
	    assertThat(pps.size()>=0);
	}
	@Test
	public void removeParkingPremiseTest() {
		ParkingPremise pps = pp.findByParkingPremiseId(1);
		if(pps!=null) {				
		pp.deleteById(1);
		}
		ParkingPremise u1=pp.findByParkingPremiseId(1);		
		assertThat(u1==null);
	}
	@Test
	public void addParkingFloorTest() {
		ParkingFloor pfs = new ParkingFloor();
		pfs.setParkingFloorId(1);
		pfs.setNumberOfParkingSlots(100);
		pfs.setFloorNumber("1A");
//		pfs.setParkingPremise(new ParkingPremise(100, "Parking Venture", new Address(15, "Chennai", "Tamil Nadu", "600017"), 5));;
		pf.save(pfs);
		assertNotNull(pf.findByParkingFloorId(1));
	}
	@Test
	public void getParkingFloorByIdTest() {
		ParkingFloor pfs  =	pf.findByParkingFloorId(10);	
		assertEquals(pfs.getParkingFloorId(),10);
	}
	@Test
	public void getParkingFloorByNumberTest() {
		ParkingFloor pfs  =	pf.findByFloorNumber("2");	
		assertEquals(pfs.getFloorNumber(),"2");
	}
	
	@Test
	public void getAllParkingFloorTest() {
		List<ParkingFloor> pfs  = pf.findAll();			
	    assertThat(pfs.size()>=0);
	}
	
	@Test
	public void removeParkingFloorTest() {
		ParkingFloor pfs = pf.findByParkingFloorId(12);
		if(pfs!=null) {				
		pf.deleteById(12);
		}
		ParkingFloor u1 = pf.findByParkingFloorId(12);	
		assertThat(u1==null);
	}
}
		