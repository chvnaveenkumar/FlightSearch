package com.expedia.flightsearch.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expedia.flightsearch.entity.Flight;
import com.expedia.flightsearch.service.FlightService;

@RestController
@RequestMapping("/flightapi")
public class FlightRestController {

	private FlightService flightService;
	
	@Autowired
	public FlightRestController(FlightService theFlightService)
	{
		flightService = theFlightService;
	}
	
	@GetMapping("/flights")
	public List<Flight> findAllFlights(){
		return flightService.findAll();
	}
	
	
	@GetMapping("/searchflights")
	public List<Flight> searchFlights( @RequestParam String departure){
		
		List<Flight> flights = flightService.searchFlights(departure);
		System.out.println(flights + "flights");
		if(flights == null || flights.size() == 0) {
		//throw  new RuntimeException("Employee id not found --"+ employeeId);
		throw new FlightNotFoundException(" No Flights found after/before departure  - "+ departure);
		}
		else {
		return flights;
		}
	}
	
}
