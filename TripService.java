package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Trip;


public interface TripService {

	public List<Trip> findAll();
	
	public Trip findById(int theId);
	
	public void save(Trip theTrip);
	
	public void deleteById(int theId);
}
