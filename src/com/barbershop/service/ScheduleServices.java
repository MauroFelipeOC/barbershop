package com.barbershop.service;

import java.util.Set;

import com.barbershop.model.Scheduling;
import com.barbershop.repository.SchedulesRepository;

public class ScheduleServices {
	
	private static Set<Scheduling> schedules = SchedulesRepository.schedules;
	
	public static boolean save(Scheduling scheduling) {
		boolean isAvailable = true;
		for(Scheduling s : schedules) {
			if(s.getBarber().equals(scheduling.getBarber())
					&& s.getDate().equals(scheduling.getDate())) {
				isAvailable = false;
			}
		}
		if(isAvailable) {
			schedules.add(scheduling);
		}
		return isAvailable;
	}

}
