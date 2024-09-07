package com.barbershop.repository;

import org.springframework.stereotype.Component;

import com.barbershop.model.Barber;

@Component
public class BarberDAO extends DAO<Barber>{
	
	public BarberDAO() {
		super(Barber.class);
	}

}
