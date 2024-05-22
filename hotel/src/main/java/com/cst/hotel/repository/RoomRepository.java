package com.cst.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cst.hotel.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{

}
