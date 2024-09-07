package com.barbershop.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.exception.ScheduleConflictException;
import com.barbershop.model.Scheduling;
import com.barbershop.repository.SchedulesRepository;
import com.barbershop.service.util.ScheduleUtil;

@Service
public class ScheduleServices {

//	private static Set<Scheduling> schedules = SchedulesRepository.schedules;
	@Autowired
	SchedulesRepository schedulesRepository;
//	SchedulesRepository schedulesRepository = new SchedulesRepository();

	/**
	 * Saves a new scheduling in the schedule's repository
	 * @param scheduling - scheduling to save
	 * **/
	public void save(Scheduling scheduling) {

		// TODO criar classe para validações de negócio
//		Scheduling conflictingSchedule = ScheduleUtil.verifyScheduleConflict(scheduling, schedulesRepository.schedules);
//		if (conflictingSchedule != null) {
//			throw new ScheduleConflictException(conflictingSchedule, scheduling);
//		}

//		schedulesRepository.schedules.add(scheduling);
		schedulesRepository.addAtomic(scheduling);
	}
	
	public Set<Scheduling> listAll(){
		return schedulesRepository.schedules;
	}

}
