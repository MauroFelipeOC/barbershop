package com.barbershop.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.barbershop.model.types.ServicesType;

public class Scheduling {
	
	private LocalDate date;
	private LocalTime time;
	private Client client;
	private Barber barber;
	private ServicesType serviceType;
	private LocalDateTime createdTime;	

	public Scheduling(LocalDate date, LocalTime time, Client client, Barber barber, ServicesType serviceType) {
		super();
		this.date = date;
		this.time = time;
		this.client = client;
		this.barber = barber;
		this.serviceType = serviceType;
	}
		
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Barber getBarber() {
		return barber;
	}

	public void setBarber(Barber barber) {
		this.barber = barber;
	}

	public ServicesType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServicesType serviceType) {
		this.serviceType = serviceType;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public String toString() {
		return "Client: " + this.client.getName() + ", Barber: " +  this.barber.getName() + ", Scheduled for: " + this.getTime().toString() + " " + this.getDate().toString();
	}
}
