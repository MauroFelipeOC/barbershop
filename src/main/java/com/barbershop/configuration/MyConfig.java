package com.barbershop.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
@ComponentScan("com.barbershop")
public class MyConfig {
	
//	@Bean
//	public ScheduleServices scheduleServices() {
//		return new ScheduleServices();
//	}
//	
//	@Bean
//	public SchedulesRepository schedulesRepository() {
//		return new SchedulesRepository();
//	}

}
