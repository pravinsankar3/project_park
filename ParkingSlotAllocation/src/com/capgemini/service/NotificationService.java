package com.capgemini.service;

import com.capgemini.exceptions.NotificationException;
import com.capgemini.model.ParkingSlots;
import com.capgemini.model.User;

public interface NotificationService {
	public void sendRegistrationEmail(User user) throws NotificationException;
	public void sendParkingConfirmationEmail(User user, ParkingSlots slot) throws NotificationException;
	public void sendParkingCancellationEmail(User user, ParkingSlots slot) throws NotificationException;
	public void sendForgotPasswordEmail(User user) throws NotificationException;
	public void sendLoginIdEmail(String email) throws NotificationException;
}
