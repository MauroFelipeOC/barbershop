package com.barbershop.unittest.service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.barbershop.model.Barber;
import com.barbershop.model.Client;
import com.barbershop.model.Scheduling;
import com.barbershop.model.types.ServicesType;
import com.barbershop.service.util.ScheduleUtil;

public class ScheduleUtilTest {
	
	@Test
	void sameDateAndDifferentTime() {
		Barber b1 = new Barber("b1");
		
		Client c1 = new Client("c1");
		LocalDate ld1 = LocalDate.now().plusWeeks(1);
		LocalTime lt1 = LocalTime.of(14, 00);
		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR);
		Set<Scheduling> schedules = new HashSet<>();
		schedules.add(s1);
		
		
		Client c2 = new Client("c2");
		LocalDate ld2 = LocalDate.now().plusWeeks(1);
		LocalTime lt2 = LocalTime.of(16, 00);
		Scheduling s2 = new Scheduling(ld2, lt2, c2, b1, ServicesType.HAIR_AND_BEARD);
		
		assertNull(ScheduleUtil.verifyScheduleConflict(s2, schedules));
	}
	
	@Test
	void differentDateAndSameTime() {
		Barber b1 = new Barber("b1");
		
		Client c1 = new Client("c1");
		LocalDate ld1 = LocalDate.now().plusWeeks(1);
		LocalTime lt1 = LocalTime.of(14, 00);
		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR);
		Set<Scheduling> schedules = new HashSet<>();
		schedules.add(s1);
		
		
		Client c2 = new Client("c2");
		LocalDate ld2 = LocalDate.now().plusWeeks(2);
		LocalTime lt2 = LocalTime.of(14, 00);
		Scheduling s2 = new Scheduling(ld2, lt2, c2, b1, ServicesType.HAIR_AND_BEARD);
		
		assertNull(ScheduleUtil.verifyScheduleConflict(s2, schedules));
	}
	
	@Test
	void sameDateAndSameTime() {
		Barber b1 = new Barber("b1");
		
		Client c1 = new Client("c1");
		LocalDate ld1 = LocalDate.now().plusWeeks(1);
		LocalTime lt1 = LocalTime.of(14, 00);
		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR);
		Set<Scheduling> schedules = new HashSet<>();
		schedules.add(s1);
		
		
		Client c2 = new Client("c2");
		LocalDate ld2 = LocalDate.now().plusWeeks(1);
		LocalTime lt2 = LocalTime.of(14, 00);
		Scheduling s2 = new Scheduling(ld2, lt2, c2, b1, ServicesType.HAIR_AND_BEARD);
		
		assertEquals(s1, ScheduleUtil.verifyScheduleConflict(s2, schedules));
	}
	
	@Test
	void sameDateAndSameInterval() {
		Barber b1 = new Barber("b1");
		
		Client c1 = new Client("c1");
		LocalDate ld1 = LocalDate.now().plusWeeks(1);
		LocalTime lt1 = LocalTime.of(14, 00);
		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR);
		Set<Scheduling> schedules = new HashSet<>();
		schedules.add(s1);
		
		
		Client c2 = new Client("c2");
		LocalDate ld2 = LocalDate.now().plusWeeks(1);
		ServicesType serviceType = ServicesType.HAIR_AND_BEARD;
		LocalTime lt2 = lt1.minusMinutes(serviceType.getServiceDuration().getMinute() - 1);
		Scheduling s2 = new Scheduling(ld2, lt2, c2, b1, serviceType);
		
		assertEquals(s1, ScheduleUtil.verifyScheduleConflict(s2, schedules));
	}

}
