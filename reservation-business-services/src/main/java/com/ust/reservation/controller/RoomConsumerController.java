package com.ust.reservation.controller;

import com.ust.reservation.client.RoomServiceClient;
import com.ust.reservation.feignclient.RoomServiceWithFeign;
import com.ust.reservation.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/roomsConsumer")
public class RoomConsumerController {
	
	@Autowired
	private RoomServiceClient roomServiceClient;
	
	@Autowired
	private RoomServiceWithFeign roomServiceWithFeign;
	
	@RequestMapping(value="/getRooms", method=RequestMethod.GET)
	public List<Room> getAllRooms(){
		return roomServiceClient.getRoomsInfo();
	}
	
	@RequestMapping(value="/getRoomsWithFeign", method=RequestMethod.GET)
	public List<Room> getAllRoomsWithFeign(){
		return roomServiceWithFeign.findAll(null);
	}
}
