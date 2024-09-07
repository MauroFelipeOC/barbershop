package com.barbershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.model.Barber;
import com.barbershop.repository.BarberDAO;

@Service
public class BarberServices {
	
	@Autowired
	private BarberDAO barberDAO;
	
	public Barber findById(long id) {
		return barberDAO.getById(id);
	}

}
