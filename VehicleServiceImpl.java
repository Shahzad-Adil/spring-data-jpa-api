package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.VehicleRepository;
import com.example.demo.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	

	private VehicleRepository vehicleRepository;
	
	@Autowired
	public VehicleServiceImpl(VehicleRepository theVehicleRepository) {
		vehicleRepository = theVehicleRepository;
	}
	
	@Override
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}
	
	@Override
	public Vehicle findById(int theId) {
		Optional<Vehicle> result = vehicleRepository.findById(theId);
		
		Vehicle theVehicle = null;
		
		if (result.isPresent()) {
			theVehicle = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Vehicle id - " + theId);
		}
		
		return theVehicle;
	}

	@Override
	public void save(Vehicle theVehicle) {
		vehicleRepository.save(theVehicle);
	}

	@Override
	public void deleteById(int theId) {
		vehicleRepository.deleteById(theId);
	}


}
