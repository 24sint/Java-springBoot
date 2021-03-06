package com.tts.rsvrInClass.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tts.rsvrInClass.model.Event;
import com.tts.rsvrInClass.model.Reservation;
import com.tts.rsvrInClass.model.User;
import com.tts.rsvrInClass.repository.ReservationRepository;
import com.tts.rsvrInClass.service.EventServiceImpl;
import com.tts.rsvrInClass.service.UserServiceImpl;



@RestController
@CrossOrigin
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private EventServiceImpl eventServiceImpl;
	@Autowired
	private ReservationRepository reservationRepository;
	
	@PostMapping()
	public void addReservation(@RequestParam Long userId, @RequestParam Long eventId, @RequestParam(required = false) String status) {
		if(status == null) {
			status = "Pending";
		}
		Event event = eventServiceImpl.findEventById(eventId);
		User user = userServiceImpl.findUserById(userId);
		Reservation reservation = new Reservation(user, event, status);
		reservationRepository.save(reservation);
	}
	
	@PutMapping("/{id}")
	public void changeStatus(@PathVariable Long id, @RequestParam String status) {
		Reservation reservation = reservationRepository.findReservationById(id);
		reservation.setStatus(status);
		reservationRepository.save(reservation);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReservationById(@PathVariable Long id) {
		reservationRepository.deleteById(id);
	}
	
}