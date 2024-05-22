package com.cst.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.hotel.model.User;
import com.cst.hotel.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	public Optional<User> getById(int id) {
		return userRepo.findById(id);
	}
	
	public User findByEmail(String email){
		return userRepo.findByEmail(email);
	}

	public User add(User user) {
		User ex = userRepo.save(user);
		return ex;
	}

	public String update(User user) {
		userRepo.save(user);
		return "Successfully Updated";
	}

	public String delete(int id) {
		userRepo.deleteById(id);
		return "Successfully Deleted";
	}
	
	
	
	
	
	

}