package com.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.model.Barber;
import com.barbershop.service.BarberServices;

@RestController
@RequestMapping("/barber")
public class BarberController {
	
	@Autowired
	BarberServices service;
	
	@PostMapping
	public Barber create(@RequestBody Barber barber) {
		return service.save(barber);
	}
	
	@GetMapping
	public Barber find(Long id) {
		return service.findById(id);
	}

}
