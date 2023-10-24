package com.barbershop.exception;

import com.barbershop.model.Scheduling;

public class ScheduleConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public ScheduleConflictException(String message) {
		super(message);
		this.message = message;
	}

	public ScheduleConflictException(Scheduling accepted, Scheduling rejected) {
		super();
		this.message = this.createConflictsMessage(accepted, rejected);
	}

	private String createConflictsMessage(Scheduling accepted, Scheduling rejected) {
		String message =
				"STORED: " + accepted.toString() + "\n"
				+ "REJECTED: " + rejected.toString();

		return message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
