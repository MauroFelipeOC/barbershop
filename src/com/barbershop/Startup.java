package com.barbershop;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

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
		
		LocalDate ld1 = LocalDate.of(2023, Month.JULY, 8);
		LocalTime lt1 = LocalTime.of(14, 50);
		LocalDate ld2 = LocalDate.of(2023, Month.JULY, 8);
		LocalTime lt2 = LocalTime.of(14, 20);
		
		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR);
		ScheduleController.createScheduling(s1);
		
		Scheduling s2 = new Scheduling(ld2, lt2, c2, b1, ServicesType.HAIR_AND_BEARD);
		ScheduleController.createScheduling(s2);
		
		SchedulesRepository.schedules.forEach(System.out::println);
		
	}
}
