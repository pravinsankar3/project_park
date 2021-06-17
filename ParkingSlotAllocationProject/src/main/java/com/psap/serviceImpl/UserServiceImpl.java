package com.psap.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.psap.exceptions.DuplicateParkingPremiseException;
import com.psap.exceptions.DuplicateUserException;
import com.psap.exceptions.InvalidLoginCredintialException;
import com.psap.exceptions.NoSuchParkingPremiseException;
import com.psap.exceptions.NoSuchUserException;
import com.psap.model.Login;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.User;
import com.psap.repository.LoginRepository;
import com.psap.repository.UserRepository;
import com.psap.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	LoginRepository lr;
	@Autowired
	UserRepository ur;
	
	User u;
	Login lo;
	
//	 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
//	user.setPassword(encoder.encode(user.getPassword()));
//    userRepository.save(user);
@Override
	public boolean registerUser(User user) throws DuplicateUserException {
	Optional<User> p = ur.findById(user.getUserId());
	if(p.isPresent())
		throw new DuplicateUserException("User is already present");
	ur.save(user);
	return true;
}

@Override
	public boolean login(Login login) throws InvalidLoginCredintialException {
		Optional<Login> l=lr.findById(login.getLoginId());
     if(!login.getPassword().equals(l.get().getPassword()))
     throw new InvalidLoginCredintialException("user Id and password not matching");
		return true;
	}

@Override
	public User findUserProfileById(long userId) throws NoSuchUserException {
	Optional<User> p = ur.findById(userId);
	if(!p.isPresent())
		throw new NoSuchUserException("No User for this ID");
	return p.get();
}

@Override
	public User findUserProfileByEmail(String email) throws NoSuchUserException {
	User p = ur.findByEmail(email);
	if(p.isActive()) {
		throw new NoSuchUserException("User is not found");
	}
	return p;
}

@Override
//	public User modifyUserProfile(User user) throws NoSuchUserException {
//	User us = (User) ur.findByUserId(user.getUserId());
//	if(user.getUserId() != ) {
//		
//		pfe.setParkingFloorId(parkingFloor.getParkingFloorId());
//	}
//	pfe.setFloorNumber(parkingFloor.getFloorNumber());
//	pfe.setNumberOfParkingSlots(parkingFloor.getNumberOfParkingSlots());
//	pfe.setParkingPremise(parkingFloor.getParkingPremise());
//	pf.save(pfe);
//	return pfe;
//}

@Override
	public boolean deleteUserById(long userId) throws NoSuchUserException {
	Optional<User> u = ur.findById(userId);
	if(!u.isPresent())
		throw new NoSuchUserException("User is not available to block");
	ur.deleteById(userId);
	return true;
}

@Override
//	public Login changePassword(Login login) throws InvalidLoginCredintialException {
//	Login l = (Login)lr.findByLoginId(login.getLoginId());
//	if(login.getLoginId() == null) {
//		throw new 
//	}
//	l.setLoginId(login.getLoginId());
//	l.setPassword(login.getPassword());
//	l.setRole(login.getRole());
//	l.setUser(login.getUser());
//	lr.save(l);
//	return l;
}

	@Override
	public void forgotPassword(String loginId) throws NoSuchUserException {
		Optional<Login> l = lr.findById(loginId);
		if(!l.isPresent()) {
			throw new NoSuchUserException("No User is found with loginId:"+loginId);
		}
		System.out.println("Password for your Account is"+lo.getPassword());
	}


	@Override
	public void forgotLoginId(String email) throws NoSuchUserException{
    if(email != u.getEmail())
    	throw new NoSuchUserException("Forgot Login Id");
    System.out.println("Login Id for your Account is:"+u.getUserId());
}
}