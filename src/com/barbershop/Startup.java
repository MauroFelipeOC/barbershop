package com.barbershop;

import java.util.Date;

import com.barbershop.controller.ScheduleController;
import com.barbershop.model.Barber;
import com.barbershop.model.Client;
import com.barbershop.model.Scheduling;
import com.barbershop.model.types.ServicesType;
import com.barbershop.repository.SchedulesRepository;

public class Startup {
	
	public static void main(String[] args) {
		Client c1 = new Client("John");
		Client c2 = new Client("Erick");
		Barber b1 = new Barber("Mariah");
		
		Scheduling s1 = new Scheduling(new Date(2023, 12, 1, 14, 0), c1, b1, ServicesType.HAIR);
		ScheduleController.createScheduling(s1);
		
		Scheduling s2 = new Scheduling(new Date(2023, 12, 1, 14, 0), c2, b1, ServicesType.HAIR_AND_BEARD);
		ScheduleController.createScheduling(s2);
		
		SchedulesRepository.schedules.forEach(a -> System.out.println(a.toString()));
		
	}
}
