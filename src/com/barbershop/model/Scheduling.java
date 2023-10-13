package com.barbershop.model;

import java.util.Date;

public class Scheduling {
	
	private Date date;
	private Client client;
	private Barber barber;
	
	public Scheduling(Date date, Client client, Barber barber) {
		super();
		this.date = date;
		this.client = client;
		this.barber = barber;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String toString() {
		return "Client: " + this.client.getName() + ", Barber: " +  this.barber.getName() + ", Scheduled for: " + this.getDate().toString();
	}
}
