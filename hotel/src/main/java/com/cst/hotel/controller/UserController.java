package com.cst.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cst.hotel.model.User;
import com.cst.hotel.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/User")
public class UserController {
	
	@Autowired
	UserService userServ;
	
	@GetMapping("/get/all")
	public List<User> getAll(){
		return userServ.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<User> getById(@PathVariable int id){
		return userServ.getById(id);
	}
	
	@GetMapping("get/email/{email}")
	public User getByEmail(@PathVariable String email) {
		return userServ.findByEmail(email);
	}
	
	@PostMapping("/add")
	public User add(@RequestBody User user) {
		return userServ.add(user);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody User user) {
		return userServ.update(user);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		return userServ.delete(id);
	}
	
}
