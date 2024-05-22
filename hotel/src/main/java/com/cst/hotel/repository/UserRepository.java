package com.cst.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cst.hotel.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByEmail(String email);
}
