package com.barbershop.exception;

import com.barbershop.model.Scheduling;

/**
 * A ScheduleConflictException is trown when an application tries
 * to save a new Scheduling with same time and date as another
 * Scheduling already saved 
 */
public class ScheduleConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	/**
	 * Constructs an {@code ScheduleConflictException} with a detail message.
     *
     * @param   message   the detail message.  
	 */
	public ScheduleConflictException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * Constructs an {@code ScheduleConflictException} with the conflicting
	 * schedulings.
     *
     * @param   accepted   the schedule already saved.  
     * @param   rejected   the schedule rejected.  
	 */
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
