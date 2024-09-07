package com.barbershop.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbershop.model.Scheduling;
import com.barbershop.service.ScheduleServices;

@Component
public class ScheduleController {
	
	@Autowired
	ScheduleServices scheduleServices;
	
	/**
	 * Create a new scheduling
	 * @param  scheduling
	 *         scheduling to be created
	 * **/
	public void createScheduling(Scheduling scheduling) {
		// TODO: validar formato
		scheduleServices.save(scheduling);
	}
	
	public Set<Scheduling> listAll(){
		return scheduleServices.listAll();
	}

}
