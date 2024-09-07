package com.barbershop.repository;

import org.springframework.stereotype.Component;

import com.barbershop.model.Client;

@Component
public class ClientDAO extends DAO<Client> {
	
	public ClientDAO() {
		super(Client.class);
		System.out.println("teste");
	}

}
