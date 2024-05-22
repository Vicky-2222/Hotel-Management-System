package com.cst.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cst.hotel.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
