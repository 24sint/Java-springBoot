package com.tts.rsvrInClass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation {
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	Long id;
	
		@ManyToOne
		@JoinColumn(name = "user_id")
		@JsonIgnore
		User user;
		
		
		@ManyToOne
		@JoinColumn(name = "event_id")
		@JsonIgnore
		
		Event event;
		
		String status;
		
		
		public Reservation(User user, Event event, String status) {
			super();
			this.user = user;
			this.event = event;
			this.status = status;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public Event getEvent() {
			return event;
		}


		public void setEvent(Event event) {
			this.event = event;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public Long getId() {
			return id;
		}


		@Override
		public String toString() {
			return "Reservation [id=" + id + ", user=" + user + ", event=" + event + ", status=" + status + "]";
		}
}
