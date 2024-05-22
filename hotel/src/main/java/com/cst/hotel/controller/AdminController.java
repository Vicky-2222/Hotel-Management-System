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

import com.cst.hotel.model.Admin;
import com.cst.hotel.service.AdminService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/Admin")
public class AdminController {
	
	@Autowired
	AdminService adminServ;
	
	@GetMapping("/get/all")
	public List<Admin> getAll(){
		return adminServ.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Admin> getById(@PathVariable int id){
		return adminServ.getById(id);
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Admin admin) {
		return adminServ.add(admin);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Admin admin) {
		return adminServ.update(admin);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		return adminServ.delete(id);
	}
	
}
