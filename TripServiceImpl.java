package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TripRepository;
import com.example.demo.entity.Trip;

@Service
public class TripServiceImpl implements TripService {



	private TripRepository tripRepository;
	
	@Autowired
	public TripServiceImpl(TripRepository theTripRepository) {
		tripRepository = theTripRepository;
	}
	
	@Override
	public List<Trip> findAll() {
		return tripRepository.findAll();
	}
	
	@Override
	public Trip findById(int theId) {
		Optional<Trip> result = tripRepository.findById(theId);
		
		Trip theTrip = null;
		
		if (result.isPresent()) {
			theTrip = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Trip id - " + theId);
		}
		
		return theTrip;
	}

	@Override
	public void save(Trip theTrip) {
		tripRepository.save(theTrip);
	}

	@Override
	public void deleteById(int theId) {
		tripRepository.deleteById(theId);
	}


}
