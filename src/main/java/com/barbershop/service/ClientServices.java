package com.barbershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.model.Client;
import com.barbershop.repository.ClientDAO;

@Service
public class ClientServices {
	
	@Autowired
	private ClientDAO clientDAO;
	
	public Client findById(long id) {
		return clientDAO.getById(id);
	}

}
