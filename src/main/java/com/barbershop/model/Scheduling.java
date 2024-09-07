package com.barbershop.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.barbershop.model.types.ServicesType;

@Entity
@Table(name = "schedules")
public class Scheduling {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate date;
	private LocalTime time;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "barber_id")
	private Barber barber;
	@Column(name = "service_type")
	@Enumerated(EnumType.STRING)
	private ServicesType serviceType;
	@Column(name = "creation_time")
	@CreationTimestamp
	private LocalDateTime createdTime;	

	/**
	 * Create a new scheduling
	 * @param  date
	 * @param  time
	 * @param  client
	 * @param  barber
	 * @param  serviceType
	 * **/
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
