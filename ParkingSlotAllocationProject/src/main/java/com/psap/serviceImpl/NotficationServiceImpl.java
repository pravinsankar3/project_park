package com.psap.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.psap.exceptions.NotificationException;
import com.psap.model.Login;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.ParkingSlots;
import com.psap.model.User;
import com.psap.model.Vehicle;
import com.psap.repository.UserRepository;
import com.psap.service.NotificationService;

@Service
public class NotficationServiceImpl implements NotificationService {

	@Autowired
	UserRepository userrepo;
	@Autowired
	User user;
	@Autowired
	Login lg;
	@Autowired
	ParkingSlots ps;
	@Autowired
	ParkingFloor pf;
	@Autowired
	ParkingPremise pp;

	@Override
	public void sendRegistrationEmail(User user) throws NotificationException {
		if (!user.isActive())
			throw new NotificationException("User is not active");
		return;

	}

	@Override
	public void sendParkingConfirmationEmail(User user, ParkingSlots slot) throws NotificationException {

		if (!user.isActive()) {
			throw new NotificationException("User is not active");
		} else {
			Date btime = ps.getBookingDate();
			Vehicle veh = ps.getVehicle();
			System.out.println("Your Booking has been confirmed for vehicle "+ veh+ "on "+btime);
		}

		return;
	}

	@Override
	public void sendParkingCancellationEmail(User user, ParkingSlots slot) throws NotificationException {
		if (!user.isActive()) {
			throw new NotificationException("User is not active");
		}else {
			Date btime = ps.getBookingDate();
			Vehicle veh = ps.getVehicle();
		}
		return;
	}

	@Override
	public void sendForgotPasswordEmail(User user) throws NotificationException {
		if (!user.isActive())
			throw new NotificationException("User is not active");
		return;
	}

	@Override
	public void sendLoginIdEmail(String email) throws NotificationException {
		String usermail = user.getEmail();
		if (!user.isActive())
			throw new NotificationException("User is not active");
		return;
	}

}
