package com.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.model.Scheduling;
import com.barbershop.service.ScheduleServices;

@RestController()
@RequestMapping("/agendamento")
public class ScheduleController {
	
	@Autowired
	ScheduleServices scheduleServices;
	
	/**
	 * Create a new scheduling
	 * @param  scheduling
	 *         scheduling to be created
	 * **/
	@PostMapping
	public void createScheduling(@RequestBody Scheduling scheduling) {
		// TODO: validar formato
		scheduleServices.save(scheduling);
	}
	
}
