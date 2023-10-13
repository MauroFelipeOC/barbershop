package com.barbershop.controller;

import com.barbershop.model.Scheduling;
import com.barbershop.service.ScheduleServices;

public class ScheduleController {
	
	public static boolean createScheduling(Scheduling scheduling) {
		return ScheduleServices.save(scheduling);
	}

}
