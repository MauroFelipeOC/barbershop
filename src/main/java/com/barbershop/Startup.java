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
import com.barbershop.repository.BarberDAO;
import com.barbershop.service.BarberServices;
import com.barbershop.service.ClientServices;

public class Startup {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
//		ScheduleController scheduleController = new ScheduleController();
		ScheduleController scheduleController = ctx.getBean(ScheduleController.class);
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
		
		BarberDAO barberDAO = new BarberDAO();
		BarberServices barberServices = ctx.getBean(BarberServices.class);
		Barber b1 = barberServices.findById(1L);
		System.out.println(b1);
		
		ClientServices clientServices = ctx.getBean(ClientServices.class);
		Client c1 = clientServices.findById(5L);
		System.out.println(c1);
		barberDAO.close();
		
		LocalDate ld1 = LocalDate.of(2025, Month.JULY, 9);
		LocalTime lt1 = LocalTime.of(13, 30);
		
		Scheduling s1 = new Scheduling(ld1, lt1, c1, b1, ServicesType.HAIR_AND_BEARD);
		scheduleController.createScheduling(s1);
		
		
	}
}
