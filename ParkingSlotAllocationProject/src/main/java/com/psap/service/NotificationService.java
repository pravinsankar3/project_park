package com.psap.service;

import com.psap.exceptions.NotificationException;
import com.psap.model.ParkingSlots;
import com.psap.model.User;

public interface NotificationService {
	public String sendRegistration(User user) throws NotificationException;
	public String sendParkingConfirmation(User user, ParkingSlots slot) throws NotificationException;
	public String sendParkingCancellation(User user, ParkingSlots slot) throws NotificationException;
	public String  sendForgotPassword(User user) throws NotificationException;
	public String  sendLoginId(User user) throws NotificationException;
}
