package com.cst.hotel.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.hotel.model.Booking;
import com.cst.hotel.model.Hotel;
import com.cst.hotel.model.Room;
import com.cst.hotel.model.User;
import com.cst.hotel.repository.BookingRepository;
import com.cst.hotel.repository.HotelRepository;
import com.cst.hotel.repository.RoomRepository;
import com.cst.hotel.repository.UserRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepo;
	@Autowired
	HotelRepository hotelRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	RoomRepository roomRepo;
	
	public List<Booking> getAll() {
		return bookingRepo.findAll();
	}
	
	public Optional<Booking> getById(int id) {
		return bookingRepo.findById(id);
	}
	
	public List<Booking> getUserId(int userId){
		return bookingRepo.findByUserId(userId);
	}

	public String add(Booking booking) {
		bookingRepo.save(booking);
		return "Successfully Added";
	}

	public String update(Booking booking) {
		bookingRepo.save(booking);
		return "Successfully Updated";
	}

	public String delete(int id) {
		Optional<Booking> book = bookingRepo.findById(id);
		int roomId = book.get().getRoomId();
		Optional<Room> room = roomRepo.findById(roomId);
		Room room1 = room.get();

		room1.setAvailable(true);
		roomRepo.save(room1);
		
		bookingRepo.deleteById(id);
		return "Successfully Deleted";
	}
	
	public String booking(int userId, int hotelId, int roomId) {
		
		Optional<Hotel> hotel = hotelRepo.findById(hotelId);
		Hotel hotel1 = hotel.get();
		Optional<Room> room = roomRepo.findById(roomId);
		Room room1 = room.get();
		Optional<User> user = userRepo.findById(userId);
		User user1 = user.get();
		if(room1.isAvailable()) {
			Booking booking=new Booking();
			
			
			booking.setHotelId(hotelId);
			booking.setHotelName(hotel1.getHotelName());
			
			booking.setRoomId(roomId);
			booking.setRoomType(room1.getRoomType());
			room1.setAvailable(false);
			
			booking.setUserId(userId);
			booking.setUserName(user1.getUserName());
			booking.setBookingStatus("Successfull");
			
			booking.setBookedDate(LocalDate.now());
			booking.setBookedTime(LocalTime.now());
			
			
			bookingRepo.save(booking);
			roomRepo.save(room1);
			
			return "Successful";
		}
		else
			return "Room is unavailable, please check other rooms.";
		
		
	}
}
