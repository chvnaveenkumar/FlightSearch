package com.expedia.flightsearch.dao;

import java.util.List;

import com.expedia.flightsearch.entity.Flight;

public interface FlightDAO {

	List<Flight> findAll();

	List<Flight> searchFlights(String Departure);

}
