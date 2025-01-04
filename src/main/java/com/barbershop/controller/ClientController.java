package com.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.model.Client;
import com.barbershop.service.ClientServices;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	ClientServices service;
	
	@PostMapping
	public Client create(@RequestBody Client client) {
		return service.save(client);
	}
	
	@GetMapping("/{id}")
	public Client findById(@PathVariable Long id) {
		return service.findById(id);
	}

}