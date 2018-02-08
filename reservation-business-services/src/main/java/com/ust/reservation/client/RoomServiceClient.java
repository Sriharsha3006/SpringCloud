package com.ust.reservation.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ust.reservation.model.Room;

@Service
public class RoomServiceClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getRoomsInfo_FallBack")
	public List<Room> getRoomsInfo(){
		ResponseEntity<List<Room>> response = restTemplate.exchange("http://ROOMSERVICEPRODUCER/rooms", 
																	HttpMethod.GET, null,
																	new ParameterizedTypeReference<List<Room>>() {
																	});
		return response.getBody();
	}
	
	public List<Room> getRoomsInfo_FallBack(){
		List<Room> rml = new ArrayList<>();
		Room rm = new Room();
		rm.setId(1);
		rm.setName("default");
		rm.setRoomNumber("C0");
		rm.setBedInfo("This is a failed service");
		rml.add(rm);
		return rml;
	}
}
