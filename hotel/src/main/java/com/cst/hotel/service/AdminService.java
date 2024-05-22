package com.cst.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.hotel.model.Admin;
import com.cst.hotel.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepo;
	
	public List<Admin> getAll() {
		return adminRepo.findAll();
	}

	public String add(Admin admin) {
		adminRepo.save(admin);
		return "Successfully Added";
	}

	public String update(Admin admin) {
		adminRepo.save(admin);
		return "Successfully Updated";
	}

	public String delete(int id) {
		adminRepo.deleteById(id);
		return "Successfully Deleted";
	}

	public Optional<Admin> getById(int id) {
		return adminRepo.findById(id);
	}
	
	
	
	
	
	

}
