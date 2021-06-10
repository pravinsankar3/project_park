package com.psap.dao;

import java.sql.SQLException;

import com.psap.model.Login;
import com.psap.model.User;

public interface UserDao {
	public boolean registerUser(User user) throws SQLException;
	public boolean login(Login login) throws SQLException;
	public User readUserProfileById(long userId) throws SQLException;
	public User readUserProfileByEmail(String email) throws SQLException;
	public User updateUserProfile(User user) throws SQLException;
	public boolean deleteUserById(long userId) throws SQLException;
	public Login changePassword(Login login) throws SQLException;
}
