package com.cst.hotel.model;

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
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private long userNum;
	private String address;
	private int age;
	private String email;
	private String password;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> booking= new ArrayList<Booking>();
	
	
	
	public List<Booking> getBooking() {
		return booking;
	}
	public void setBooking(List<Booking> booking) {
		this.booking = booking;
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
	public long getUserNum() {
		return userNum;
	}
	public void setUserNum(long userNum) {
		this.userNum = userNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int userId, String userName, long userNum, String address, int age, String email, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userNum = userNum;
		this.address = address;
		this.age = age;
		this.email = email;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
