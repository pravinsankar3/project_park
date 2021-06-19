package com.psap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psap.model.Login;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.User;
import com.psap.repository.LoginRepository;
import com.psap.repository.UserRepository;

@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	UserRepository urepo;
	@Autowired
	LoginRepository lrepo;

	@Test
	public void registerTest() {
		User u = new User();
		u.setUserId(1);
		u.setActive(true);
		u.setEmail("abx@hmail.com");
		u.setFirstName("annf");
		u.setLastName("hgfh");
		u.setMobile("123456789");
		urepo.save(u);
		assertNotNull(urepo.findByUserId(1));
	}
	@Test
	public void loginTest() {
		Login l = new Login(); 
		l.setLoginId("123A");
		l.setPassword("hello123");
		lrepo.save(l);
		assertNotNull(lrepo.findById("123A"));
	}
	@Test
	public void findUserProfileByIdTest() {
		User u  =	urepo.findByUserId(1);
		assertEquals(u.getUserId(),1);
	}
	
	@Test
	public void findUserProfileByEmailTest() {
		User u = urepo.findByEmail("abx@hmail.com");
		assertEquals(u.getEmail(),"abx@hmail.com");
	}
	@Test
	public void deleteUserByIdTest() {
		User u = urepo.findByUserId(1);
		if(u!=null) {				
		urepo.deleteById((long) 1);
		}
		User u1 = urepo.findByUserId(1);
		assertThat(u1==null);
	}
	
}
