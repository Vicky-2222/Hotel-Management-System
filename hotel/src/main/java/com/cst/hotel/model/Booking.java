package com.cst.hotel.model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private String bookingStatus;
	private int hotelId;
	private String hotelName ;
	private int roomId;
	private String roomType;
	private int userId;
	private String userName;
	
	private LocalDate BookedDate;
	private LocalTime BookedTime;
	
	@ManyToOne
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getBookedDate() {
		return BookedDate;
	}
	public void setBookedDate(LocalDate bookedDate) {
		BookedDate = bookedDate;
	}
	public LocalTime getBookedTime() {
		return BookedTime;
	}
	public void setBookedTime(LocalTime bookedTime) {
		BookedTime = bookedTime;
	}
	public Booking(int bookingId, String bookingStatus, int hotelId, String hotelName, int roomId, String roomType,
			int userId, String userName, LocalDate bookedDate, LocalTime bookedTime) {
		super();
		this.bookingId = bookingId;
		this.bookingStatus = bookingStatus;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.roomId = roomId;
		this.roomType = roomType;
		this.userId = userId;
		this.userName = userName;
		BookedDate = bookedDate;
		BookedTime = bookedTime;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
