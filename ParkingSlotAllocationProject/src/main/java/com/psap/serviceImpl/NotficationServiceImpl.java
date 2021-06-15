package com.psap.serviceImpl;

import com.psap.exceptions.NotificationException;
import com.psap.model.ParkingSlots;
import com.psap.model.User;
import com.psap.service.NotificationService;

public class NotficationServiceImpl implements NotificationService {

	@Override
	public void sendRegistrationEmail(User user) throws NotificationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendParkingConfirmationEmail(User user, ParkingSlots slot) throws NotificationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendParkingCancellationEmail(User user, ParkingSlots slot) throws NotificationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendForgotPasswordEmail(User user) throws NotificationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendLoginIdEmail(String email) throws NotificationException {
		// TODO Auto-generated method stub
		
	}

}
