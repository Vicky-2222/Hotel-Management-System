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

import com.cst.hotel.model.Room;
import com.cst.hotel.service.RoomService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/Room")
public class RoomController {
	
	@Autowired
	RoomService roomServ;
	
	@GetMapping("/get/{id}")
	public Optional<Room> getById(@PathVariable int id){
		return roomServ.getById(id);
	}
	
	@GetMapping("/getall/HotelId/{id}")
	public List<Room> getByHotelId(@PathVariable int id){
		List<Room> roomById =  roomServ.getByHotelId(id);
		return roomById;
	}
	
	@GetMapping("/get/all")
	public List<Room> getAll(){
		return roomServ.getAll();
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Room room) {
		return roomServ.add(room);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Room room) {
		return roomServ.update(room);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		return roomServ.delete(id);
	}
	
}
