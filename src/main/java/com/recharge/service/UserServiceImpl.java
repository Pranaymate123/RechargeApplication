package com.recharge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recharge.model.User;
import com.recharge.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User saveUser(User user) {
		
		User u;
		try {
			u = repository.save(user);
			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Internal Server Error");
		}
		return null;
		
	}

	@Override
	public User getUser(int id) {
		Optional<User> u=repository.findById(id);
		try {
			return u.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Record Not Found In The Database");
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		try {
			List<User> lst=repository.findAll();
			return lst;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Internal Server Error");
		}
		
		return null;
	}

	@Override
	public void deleteUser(int id) {
		
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User updateUser(User user, int id) {
		User u;
		try {
			u = repository.save(user);
			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Updation Failed");
		}
		return null;
	}

	@Override
	public User verifyUser(String email, String password) {
		User u=repository.findByEmailAndPassword(email,password);
		return u;
	}
	
	
}
