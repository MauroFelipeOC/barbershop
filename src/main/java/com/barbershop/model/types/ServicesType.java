package com.barbershop.model.types;

import java.time.LocalTime;

public enum ServicesType {
	
	HAIR(LocalTime.of(0, 20)),
	BEARD(LocalTime.of(0, 15)),
	HAIR_AND_BEARD(LocalTime.of(0, 30));
	
	private final LocalTime serviceDuration;
	
	ServicesType(LocalTime serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public LocalTime getServiceDuration() {
		return serviceDuration;
	}
	
}
