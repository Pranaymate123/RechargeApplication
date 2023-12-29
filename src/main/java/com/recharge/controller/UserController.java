package com.recharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recharge.model.User;
import com.recharge.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/users")
	public ResponseEntity<User> saveRecord(@RequestBody User user)
	{
		User u=service.saveUser(user);
		if(u!=null)
		{
			ResponseEntity<User> resp=new ResponseEntity<User>(u,HttpStatus.CREATED);
			return resp;
		}
		ResponseEntity<User> resp=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		return resp;
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getRecord(@PathVariable int id)
	{
		User u=service.getUser(id);
		if(u!=null)
		{
			ResponseEntity<User> resp=new ResponseEntity<User>(u,HttpStatus.FOUND);
			return resp;
		}
		ResponseEntity<User> resp=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resp;
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAll()
	{
		List<User> lst=service.getAllUsers();
		if(lst!=null)
		{
			ResponseEntity<List<User>> resp=new ResponseEntity<List<User>>(lst,HttpStatus.FOUND);
			return resp;
		}
		ResponseEntity<List<User>> resp=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id)
	{
		service.deleteUser(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id)
	{
		user.setId(id);
		User u=service.updateUser(user, id);
		if(u!=null)
		{
			ResponseEntity<User> resp=new ResponseEntity<User>(u,HttpStatus.ACCEPTED);
			return resp;
		}
		ResponseEntity<User> resp=new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		return resp;
	}
	@GetMapping("/users/{email}/{password}")
	public ResponseEntity<User> verifyUser(@PathVariable String email,@PathVariable String password)
	{
		User u=service.verifyUser(email, password);
		if(u!=null)
		{
			ResponseEntity<User> resp=new ResponseEntity<User>(u,HttpStatus.FOUND);
			return resp;
		}
		ResponseEntity<User> resp=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resp;
		
		
	}

	
}
