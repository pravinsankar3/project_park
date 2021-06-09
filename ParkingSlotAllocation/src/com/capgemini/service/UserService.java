package com.capgemini.service;

import com.capgemini.exceptions.DuplicateUserException;
import com.capgemini.exceptions.InvalidLoginCredintialException;
import com.capgemini.exceptions.NoSuchUserException;
import com.capgemini.model.Login;
import com.capgemini.model.User;

public interface UserService {
	public boolean registerUser(User user) throws DuplicateUserException;
	public boolean login(Login login) throws InvalidLoginCredintialException;
	public User findUserProfileById(long userId) throws NoSuchUserException;
	public User findUserProfileByEmail(String email) throws NoSuchUserException;
	public User modifyUserProfile(User user) throws NoSuchUserException;
	public boolean deleteUserById(long userId) throws NoSuchUserException;
	public Login changePassword(Login login) throws InvalidLoginCredintialException;
	public void forgotPassword(String loginId) throws NoSuchUserException;
	public void forgotLoginId(String email) throws NoSuchUserException;
}
