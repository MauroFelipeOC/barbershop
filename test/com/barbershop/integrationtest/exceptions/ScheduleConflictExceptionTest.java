package com.barbershop.integrationtest.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.barbershop.controller.ScheduleController;
import com.barbershop.exception.ScheduleConflictException;
import com.barbershop.model.Barber;
import com.barbershop.model.Client;
import com.barbershop.model.Scheduling;
import com.barbershop.model.types.ServicesType;
import com.barbershop.repository.SchedulesRepository;

public class ScheduleConflictExceptionTest {
	
	@BeforeEach
	void cleanRepository() {
		SchedulesRepository.schedules.clear();
	}

	@Test
	void testScheduleConflict01() {
		Barber b1 = new Barber("b1");
		
		Client c1 = new Client("c1");
		LocalDate ld1 = LocalDate.now().plusWeeks(1);
		LocalTime lt1 = LocalTime.of(14, 00);
		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR);
		ScheduleController.createScheduling(s1);

		Client c2 = new Client("c2");
		LocalDate ld2 = LocalDate.now().plusWeeks(1);
		LocalTime lt2 = lt1.plusMinutes(s1.getServiceType().getServiceDuration().getMinute() - 1);
		Scheduling s2 = new Scheduling(ld2, lt2, c2, b1, ServicesType.HAIR_AND_BEARD);

		assertThrows(ScheduleConflictException.class, () -> ScheduleController.createScheduling(s2));
	}

	@Test
	void testScheduleConflict02() {
		Barber b1 = new Barber("b1");

		Client c1 = new Client("c1");
		LocalDate ld1 = LocalDate.now().plusWeeks(1);
		LocalTime lt1 = LocalTime.of(14, 00);
		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR);
		ScheduleController.createScheduling(s1);

		Client c2 = new Client("c2");
		LocalDate ld2 = LocalDate.now().plusWeeks(1);
		ServicesType serviceType = ServicesType.HAIR_AND_BEARD;
		LocalTime lt2 = lt1.minusMinutes(serviceType.getServiceDuration().getMinute() - 1);
		Scheduling s2 = new Scheduling(ld2, lt2, c2, b1, serviceType);

		assertThrows(ScheduleConflictException.class, () -> ScheduleController.createScheduling(s2));
	}

	@Test
	void testScheduleNoConflict01() {
		Barber b1 = new Barber("b1");

		Client c1 = new Client("c1");
		LocalDate ld1 = LocalDate.now().plusWeeks(1);
		LocalTime lt1 = LocalTime.of(14, 00);
		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR);
		ScheduleController.createScheduling(s1);

		Client c2 = new Client("c2");
		LocalDate ld2 = LocalDate.now().plusWeeks(1);
		LocalTime lt2 = lt1.plusMinutes(s1.getServiceType().getServiceDuration().getMinute());
		Scheduling s2 = new Scheduling(ld2, lt2, c2, b1, ServicesType.HAIR_AND_BEARD);
		ScheduleController.createScheduling(s2);

		assertEquals(2, SchedulesRepository.schedules.size());
	}
	
	@Test
	void testScheduleNoConflict02() {
		Barber b1 = new Barber("b1");
		Barber b2 = new Barber("b2");
		
		Client c1 = new Client("c1");
		LocalDate ld1 = LocalDate.now().plusWeeks(1);
		LocalTime lt1 = LocalTime.of(14, 00);
		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR);
		ScheduleController.createScheduling(s1);

		Client c2 = new Client("c2");
		LocalDate ld2 = LocalDate.now().plusWeeks(1);
		LocalTime lt2 = lt1.plusMinutes(s1.getServiceType().getServiceDuration().getMinute() - 1);
		Scheduling s2 = new Scheduling(ld2, lt2, c2, b2, ServicesType.HAIR_AND_BEARD);
		ScheduleController.createScheduling(s2);
		
		assertEquals(2, SchedulesRepository.schedules.size());
	}

}
