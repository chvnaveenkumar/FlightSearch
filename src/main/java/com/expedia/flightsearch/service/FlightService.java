package com.expedia.flightsearch.service;

import java.util.List;

import com.expedia.flightsearch.entity.Flight;

public interface FlightService {

	public List<Flight> findAll();

	public List<Flight> searchFlights(String departure);
}
