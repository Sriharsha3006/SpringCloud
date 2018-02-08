package com.ust.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.Room;
@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
	
	public Room findByRoomNumber(String roomNumber);
}
