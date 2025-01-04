package com.barbershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.model.Scheduling;
import com.barbershop.service.ScheduleServices;

@RestController()
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	ScheduleServices scheduleServices;
	
	/**
	 * Create a new scheduling
	 * @param  scheduling
	 *         scheduling to be created
	 * **/
	@PostMapping
	public Scheduling createScheduling(@RequestBody Scheduling scheduling) {
		// TODO: validar formato
		return scheduleServices.save(scheduling);
	}
	
	@GetMapping("/{id}")
	public List<Scheduling> findAllByClientId(@PathVariable Long id) {
		return scheduleServices.findAllByClientId(id);
	}
	
}
