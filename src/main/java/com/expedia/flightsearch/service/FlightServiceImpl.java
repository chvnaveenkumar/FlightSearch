package com.expedia.flightsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedia.flightsearch.dao.FlightDAO;
import com.expedia.flightsearch.dao.FlightDAOImpl;
import com.expedia.flightsearch.entity.Flight;

@Service
public class FlightServiceImpl implements FlightService {

	private FlightDAO flightDAO;
	
	@Autowired
	public FlightServiceImpl(FlightDAO theFlightDAO) {
		flightDAO = theFlightDAO;
	}
	
	public List<Flight> findAll() {
		return flightDAO.findAll();
	}

	@Override
	public List<Flight> searchFlights(String departure) {
		// TODO Auto-generated method stub
		return flightDAO.searchFlights(departure);
	}

}
