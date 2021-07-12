package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Trip;
import com.example.demo.service.TripService;


@RestController
@RequestMapping("/api")
public class TripRestController {


	private TripService tripService;
	
	@Autowired
	public TripRestController(TripService theTripService) {
		tripService = theTripService;
	}
	
	@GetMapping("/trips")
	public List<Trip> findAll() {
		return tripService.findAll();
	}
	
	@GetMapping("/trips/{tripId}")
	public Trip getTrip(@PathVariable int tripId) {
		
		Trip theTrip = tripService.findById(tripId);
		
		if (theTrip == null) {
			throw new RuntimeException("Trip id not found - " + tripId);
		}
		
		return theTrip;
	}
	
	
	@PostMapping("/trips")
	public Trip addTrip(@RequestBody Trip theTrip) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theTrip.setId(0);
		
		tripService.save(theTrip);
		
		return theTrip;
	}
	
		
	@PutMapping("/trips")
	public Trip updateTrip(@RequestBody Trip theTrip) {
		
		tripService.save(theTrip);
		
		return theTrip;
	}
	
	
	@DeleteMapping("/trips/{tripId}")
	public String deleteTrip(@PathVariable int tripId) {
		
		Trip tempTrip = tripService.findById(tripId);
		
		// throw exception if null
		
		if (tempTrip == null) {
			throw new RuntimeException("Trip id not found - " + tripId);
		}
		
		tripService.deleteById(tripId);
		
		return "Deleted Trip id - " + tripId;
	}
	
}
