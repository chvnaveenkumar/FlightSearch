package com.expedia.flightsearch.rest;

public class FlightNotFoundException extends RuntimeException {

	public FlightNotFoundException(String message) {
		super(message);
	}
}
