package com.cst.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.hotel.model.Hotel;
import com.cst.hotel.repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotelRepo;
	
	public List<Hotel> getAll() {
		return hotelRepo.findAll();
	}

	public Optional<Hotel> getById(int id) {
		return hotelRepo.findById(id);
	}
	
	public String add(Hotel hotel) {
		hotelRepo.save(hotel);
		return "Successfully Added";
	}

	public String update(Hotel hotel) {
		hotelRepo.save(hotel);
		return "Successfully Updated";
	}

	public String delete(int id) {
		hotelRepo.deleteById(id);
		return "Successfully Deleted";
	}
	
	
	
	
	
	

}
