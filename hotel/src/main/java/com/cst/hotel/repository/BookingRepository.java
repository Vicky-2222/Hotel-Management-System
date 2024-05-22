package com.cst.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cst.hotel.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	List<Booking> findByUserId(int userId);

}
