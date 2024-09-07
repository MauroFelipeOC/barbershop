package com.barbershop;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.barbershop.configuration.MyConfig;
import com.barbershop.controller.ScheduleController;
import com.barbershop.model.Barber;
import com.barbershop.model.Client;
import com.barbershop.model.Scheduling;
import com.barbershop.model.types.ServicesType;

public class Startup {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
//		ScheduleController scheduleController = new ScheduleController();
//		ScheduleController scheduleController = ctx.getBean(ScheduleController.class);
//		Client c1 = new Client("John");
//		Client c2 = new Client("Erick");
//		Barber b1 = new Barber("Mariah");
//		
//		LocalDate ld1 = LocalDate.of(2023, Month.JULY, 8);
//		LocalTime lt1 = LocalTime.of(14, 50);
//		LocalDate ld2 = LocalDate.of(2023, Month.JULY, 8);
//		LocalTime lt2 = LocalTime.of(14, 20);
//		
//		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR);
//		scheduleController.createScheduling(s1);
//		
//		Scheduling s2 = new Scheduling(ld2, lt2, c2, b1, ServicesType.HAIR_AND_BEARD);
//		scheduleController.createScheduling(s2);
//		
//		scheduleController.listAll().forEach(System.out::println);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("barber");
		EntityManager em = emf.createEntityManager();
		
		Barber b1 = em.find(Barber.class, 1L);
		System.out.println(b1);
		
		em.close();
		emf.close();
		
	}
}
