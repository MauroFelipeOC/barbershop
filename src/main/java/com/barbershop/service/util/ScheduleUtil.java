package com.barbershop.service.util;

import java.time.Duration;
import java.util.Set;
import java.util.function.BiFunction;

import com.barbershop.model.Scheduling;

public class ScheduleUtil {
	
	public static Scheduling verifyScheduleConflict(Scheduling currentScheduling, Set<Scheduling> schedules) {

		Scheduling conflictingSchedule = null;

		for (Scheduling s : schedules) {
			if (s.getBarber().equals(currentScheduling.getBarber())
					&& isAtSameDay.apply(s, currentScheduling)
					&& isAtSameInterval.apply(s, currentScheduling)) {
				conflictingSchedule = s;
			}
		}

		return conflictingSchedule;
	}
	
	private static BiFunction<Scheduling, Scheduling, Boolean> isAtSameDay = (s1, s2) -> s1.getDate().isEqual(s2.getDate());
	private static BiFunction<Scheduling, Scheduling, Boolean> isAtSameInterval = (s1, s2) -> {
		if(s1.getTime().isBefore(s2.getTime())){
			long intervalo = Duration.between(s1.getTime(), s2.getTime()).toMinutes();
			return intervalo < s1.getServiceType().getServiceDuration().getMinute();
		} else {
			long intervalo = Duration.between(s2.getTime(), s1.getTime()).toMinutes();
			return intervalo < s2.getServiceType().getServiceDuration().getMinute();
		}
	};

}
