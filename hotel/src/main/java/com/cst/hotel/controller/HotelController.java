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

import com.cst.hotel.model.Hotel;
import com.cst.hotel.service.HotelService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/Hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelServ;
	
	@GetMapping("/get/all")
	public List<Hotel> getAll(){
		return hotelServ.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Hotel> getById(@PathVariable int id){
		return hotelServ.getById(id);
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Hotel hotel) {
		return hotelServ.add(hotel);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Hotel hotel) {
		return hotelServ.update(hotel);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		return hotelServ.delete(id);
	}
	
}
