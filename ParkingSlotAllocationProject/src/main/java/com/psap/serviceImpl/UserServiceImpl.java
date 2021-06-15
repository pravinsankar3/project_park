package com.psap.serviceImpl;

import com.psap.exceptions.DuplicateUserException;
import com.psap.exceptions.InvalidLoginCredintialException;
import com.psap.exceptions.NoSuchUserException;
import com.psap.model.Login;
import com.psap.model.User;
import com.psap.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean registerUser(User user) throws DuplicateUserException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(Login login) throws InvalidLoginCredintialException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUserProfileById(long userId) throws NoSuchUserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserProfileByEmail(String email) throws NoSuchUserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User modifyUserProfile(User user) throws NoSuchUserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserById(long userId) throws NoSuchUserException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Login changePassword(Login login) throws InvalidLoginCredintialException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void forgotPassword(String loginId) throws NoSuchUserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void forgotLoginId(String email) throws NoSuchUserException {
		// TODO Auto-generated method stub
		
	}

}
