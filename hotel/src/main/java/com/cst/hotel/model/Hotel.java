package com.cst.hotel.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hotel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelId;
	private String hotelName;
	private String hotelLocation;
	private String image;
	
	@OneToMany(mappedBy="hotel", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Room> room= new ArrayList<Room>();
	
	

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
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

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Hotel(int hotelId, String hotelName, String hotelLocation, String image) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.image = image;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
