package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Vehicle;


public interface VehicleService {

	public List<Vehicle> findAll();
	
	public Vehicle findById(int theId);
	
	public void save(Vehicle theVehicle);
	
	public void deleteById(int theId);
}
