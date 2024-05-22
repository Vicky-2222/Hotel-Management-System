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

import com.cst.hotel.model.Booking;
import com.cst.hotel.service.BookingService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/Booking")
public class BookingController {
	
	@Autowired
	BookingService bookingServ;
	
	@GetMapping("/get/all")
	public List<Booking> getAll(){
		return bookingServ.getAll();
	}
	
	@GetMapping("/userId/{userId}")
	public List<Booking> getByUserId(@PathVariable int userId){
		return bookingServ.getUserId(userId);
	}
	
	@GetMapping("/get/{id}")
	public Optional<Booking> getById(@PathVariable int id){
		return bookingServ.getById(id);
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Booking booking) {
		return bookingServ.add(booking);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Booking booking) {
		return bookingServ.update(booking);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return bookingServ.delete(id);
	}
	
	@PostMapping("userId/{userId}/hotelId/{hotelId}/roomId/{roomId}")
	public String booking(@PathVariable int userId, @PathVariable int hotelId,@PathVariable int roomId) {
		return bookingServ.booking(userId,hotelId,roomId);
	}
}
