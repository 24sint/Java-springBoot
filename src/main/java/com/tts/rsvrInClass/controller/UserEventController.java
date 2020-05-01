package com.tts.rsvrInClass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tts.rsvrInClass.service.EventServiceImpl;
import com.tts.rsvrInClass.service.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/userevents")
public class UserEventController {
	
	@Autowired
	private EventServiceImpl eventServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
//	@PostMapping()
//	public void saveUserEvent(@RequestParam(value="userId") Long userId, @RequestParam(value="eventId") Long eventId) {
//		
//	}
//	@DeletetMapping()
//	public void saveUserEvent(@RequestParam(value="userId") Long userId, @RequestParam(value="eventId") Long eventId) {
//		
//	}

}
