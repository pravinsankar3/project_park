package com.psap.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.psap.exceptions.NotificationException;
import com.psap.model.ParkingSlots;
import com.psap.model.User;
import com.psap.repository.LoginRepository;
import com.psap.repository.ParkingSlotsRepository;
import com.psap.repository.UserRepository;
import com.psap.repository.VehicleRepository;
import com.psap.service.NotificationService;

public class NotificationSerceImpl implements NotificationService {
	
	@Autowired
	UserRepository urepo;
	@Autowired
	ParkingSlotsRepository psrepo;
	@Autowired
	VehicleRepository vrepo;
	@Autowired
	LoginRepository lrepo;
	
	
	
	@Override
	public String sendRegistration(User user) throws NotificationException {
		if(!(user.isActive())) {
			throw new NotificationException("User is not active");
		}else {
			return "Dear"+user.getFirstName()+"Registration is Successfull. Your user id is " + user.getUserId();
		}		
	}

	@Override
	public String sendParkingConfirmation(User user, ParkingSlots slot) throws NotificationException {
		if(!(user.isActive())) {
			throw new NotificationException("User is not active");
		}else {
			return "Dear"+user.getFirstName()+"Booking has been Confirmed Successfully on vehicle num "+ slot.getVehicle()+ "at slot id "+slot.getParkingSlotId()+ "date"+slot.getParkingDate();
		}		
	}

	@Override
	public String sendParkingCancellation(User user, ParkingSlots slot) throws NotificationException {
		if(!(user.isActive())) {
			throw new NotificationException("User is not active");
		}else {
			return "Dear"+user.getFirstName()+"Booking is Cancelled on vehicle num "+ slot.getVehicle()+ "at slot id "+slot.getParkingSlotId()+ "date"+slot.getParkingDate();
		}		
	}

	@Override
	public String sendForgotPassword(User user) throws NotificationException {
		if(!(user.isActive())) {
			throw new NotificationException("User is not active");
		}else {
			return "Dear"+user.getFirstName()+"Your password is ";
		}		
	}

	@Override
	public String sendLoginId(User user) throws NotificationException {
		return "Dear"+ user.getFirstName()+"Your loginId is " ;
	}

	

}
