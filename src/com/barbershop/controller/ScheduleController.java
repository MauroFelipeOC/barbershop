package com.barbershop.controller;

import com.barbershop.model.Scheduling;
import com.barbershop.service.ScheduleServices;

public class ScheduleController {
	
	public static void createScheduling(Scheduling scheduling) {
		ScheduleServices.save(scheduling);
	}

}
