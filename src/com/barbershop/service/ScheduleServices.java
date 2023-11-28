package com.barbershop.service;

import java.util.Set;

import com.barbershop.exception.ScheduleConflictException;
import com.barbershop.model.Scheduling;
import com.barbershop.repository.SchedulesRepository;
import com.barbershop.service.util.ScheduleUtil;

public class ScheduleServices {

	private static Set<Scheduling> schedules = SchedulesRepository.schedules;

	/**
	 * Saves a new scheduling in the schedule's repository
	 * @param scheduling - scheduling to save
	 * **/
	public static void save(Scheduling scheduling) {

		Scheduling conflictingSchedule = ScheduleUtil.verifyScheduleConflict(scheduling, schedules);
		if (conflictingSchedule != null) {
			throw new ScheduleConflictException(conflictingSchedule, scheduling);
		}

		schedules.add(scheduling);
	}

}
