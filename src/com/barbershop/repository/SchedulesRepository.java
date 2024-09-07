package com.barbershop.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.barbershop.model.Scheduling;

@Component
public class SchedulesRepository {
	
	public Set<Scheduling> schedules = new HashSet<>();

}
