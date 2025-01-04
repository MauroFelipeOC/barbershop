package com.barbershop.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.model.Scheduling;
import com.barbershop.repository.SchedulesRepository;

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
	public Scheduling save(Scheduling scheduling) {

		// TODO criar classe para validações de negócio
//		Scheduling conflictingSchedule = ScheduleUtil.verifyScheduleConflict(scheduling, schedulesRepository.schedules);
//		if (conflictingSchedule != null) {
//			throw new ScheduleConflictException(conflictingSchedule, scheduling);
//		}

//		schedulesRepository.schedules.add(scheduling);
		return schedulesRepository.addAtomic(scheduling);
	}
	
	public Set<Scheduling> listAll(){
		return schedulesRepository.schedules;
	}

	public List<Scheduling> findAllByClientId(Long clientId) {
		return schedulesRepository.findAllByClientId(clientId);
	}

}
