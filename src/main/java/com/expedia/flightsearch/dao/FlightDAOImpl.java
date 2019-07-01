package com.expedia.flightsearch.dao;

import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.expedia.flightsearch.entity.Flight;
import com.expedia.flightsearch.entity.Flights;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class FlightDAOImpl implements FlightDAO{

	
	@Override
	public List<Flight> findAll() {
	
		Flights theFlights = null;
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
	
			// read JSON file and map/convert to Java POJO:
			theFlights =
					mapper.readValue(
							new ClassPathResource("flight.json").getFile(), Flights.class);
			}
			catch(Exception exc) {
				exc.printStackTrace();
			}
		return theFlights.getFlights();
	}

	@Override
	public List<Flight> searchFlights(String Departure) {
		
		Flights theFlights = null;
		ArrayList<Flight> displayFlights = new ArrayList<>();
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO:
						theFlights =
								mapper.readValue(
										new ClassPathResource("flight.json").getFile(), Flights.class);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");
			LocalTime departureTime = LocalTime.parse(Departure, formatter);
			
			
			ListIterator<Flight> i = theFlights.getFlights().listIterator();		
			
			while(i.hasNext()) {
				Flight flight = i.next();
				if(departureTime.minusHours(5).isBefore(LocalTime.parse(flight.getDeparture(), formatter)) && departureTime.plusHours(5).isAfter(LocalTime.parse(flight.getDeparture(), formatter))) {
					displayFlights.add(flight);
				}
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		System.out.println(displayFlights);
		return displayFlights;
	}
}
