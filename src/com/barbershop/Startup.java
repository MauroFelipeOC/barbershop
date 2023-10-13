package com.barbershop;

import java.util.Date;

import com.barbershop.controller.ScheduleController;
import com.barbershop.model.Barber;
import com.barbershop.model.Client;
import com.barbershop.model.Scheduling;
import com.barbershop.repository.SchedulesRepository;

public class Startup {
	
	public static void main(String[] args) {
		Client c1 = new Client("Joao");
		Client c2 = new Client("Kleber");
		Barber b1 = new Barber("Pedro");
		
		Scheduling s1 = new Scheduling(new Date(2023, 12, 1, 14, 0), c1, b1);
		ScheduleController.createScheduling(s1);
		
		Scheduling s2 = new Scheduling(new Date(2023, 12, 2, 14, 0), c2, b1);
		ScheduleController.createScheduling(s2);
		
		SchedulesRepository.schedules.forEach(a -> System.out.println(a.toString()));
		
	}
}
