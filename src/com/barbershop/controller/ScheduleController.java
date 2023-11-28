package com.barbershop.controller;

import com.barbershop.model.Scheduling;
import com.barbershop.service.ScheduleServices;

public class ScheduleController {
	
	/**
	 * Create a new scheduling
	 * @param  scheduling
	 *         scheduling to be created
	 * **/
	public static void createScheduling(Scheduling scheduling) {
		ScheduleServices.save(scheduling);
	}

}
