package com.psap.service;

import com.psap.exceptions.NotificationException;
import com.psap.model.ParkingSlots;
import com.psap.model.User;

public interface NotificationService {
	public void sendRegistrationEmail(User user) throws NotificationException;
	public void sendParkingConfirmationEmail(User user, ParkingSlots slot) throws NotificationException;
	public void sendParkingCancellationEmail(User user, ParkingSlots slot) throws NotificationException;
	public void sendForgotPasswordEmail(User user) throws NotificationException;
	public void sendLoginIdEmail(String email) throws NotificationException;
}
