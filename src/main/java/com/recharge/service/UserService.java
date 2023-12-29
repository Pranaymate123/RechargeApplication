package com.recharge.service;

import java.util.List;

import com.recharge.model.User;

public interface UserService {
	
	public User saveUser(User user);
	public User getUser(int id);
	public List<User> getAllUsers();
	public void deleteUser(int id);
	public User updateUser(User user,int id);
}
