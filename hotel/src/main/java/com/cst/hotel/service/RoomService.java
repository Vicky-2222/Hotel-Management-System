package com.cst.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.hotel.model.Hotel;
import com.cst.hotel.model.Room;
import com.cst.hotel.repository.HotelRepository;
import com.cst.hotel.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepo;
	
	@Autowired
	HotelRepository hotelRepo;
	
	public Optional<Room> getById(int id){
		return roomRepo.findById(id);
	}
	
	public List<Room> getAll() {
		return roomRepo.findAll();
	}

	public List<Room> getByHotelId(int id) {
		Optional<Hotel> hotelId = hotelRepo.findById(id);
		List<Room> room =null;
		if(hotelId.isPresent()) {
			Hotel hotel = hotelId.get();
			room = hotel.getRoom();			
	}
		return  room;

	}
	
	public String add(Room room) {
		roomRepo.save(room);
		return "Successfully Added";
	}

	public String update(Room room) {
		roomRepo.save(room);
		return "Successfully Updated";
	}

	public String delete(int id) {
		roomRepo.deleteById(id);
		return "Successfully Deleted";
	}
	
	
	
	
	
	

}
