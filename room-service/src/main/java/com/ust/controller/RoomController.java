package com.ust.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.Room;
import com.ust.repository.RoomRepository;

@RestController
@RequestMapping(value="/rooms")
public class RoomController {
	
	@Autowired
	RoomRepository roomRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Room> findAll(@RequestParam(name="roomNumber", required=false)String roomNumber){
		if(StringUtils.isNotEmpty(roomNumber)) {
			return Collections.singletonList(roomRepository.findByRoomNumber(roomNumber));
		}
		return (List<Room>) roomRepository.findAll();
	}
}
