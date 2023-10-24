package com.barbershop.service;

import java.util.Set;

import com.barbershop.exception.ScheduleConflictException;
import com.barbershop.model.Scheduling;
import com.barbershop.repository.SchedulesRepository;

public class ScheduleServices {

	private static Set<Scheduling> schedules = SchedulesRepository.schedules;

	public static void save(Scheduling scheduling) {

		Scheduling conflictingSchedule = verifyScheduleConflict(scheduling);
		if (conflictingSchedule != null) {
			throw new ScheduleConflictException(conflictingSchedule, scheduling);
		}

		schedules.add(scheduling);
	}

	private static Scheduling verifyScheduleConflict(Scheduling scheduling) {

		Scheduling conflictingSchedule = null;

		for (Scheduling s : schedules) {
			if (s.getBarber().equals(scheduling.getBarber())
					&& s.getDate().equals(scheduling.getDate())) {
				conflictingSchedule = s;
			}
		}

		return conflictingSchedule;
	}

}
