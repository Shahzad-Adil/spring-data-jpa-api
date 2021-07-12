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

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;



@RestController
@RequestMapping("/api")
public class VehicleRestController {


	private VehicleService vehicleService;
	
	@Autowired
	public VehicleRestController(VehicleService theVehicleService) {
		vehicleService = theVehicleService;
	}
	
	@GetMapping("/vehicles")
	public List<Vehicle> findAll() {
		return vehicleService.findAll();
	}
	
	@GetMapping("/vehicles/{vehicleId}")
	public Vehicle getVehicle(@PathVariable int vehicleId) {
		
		Vehicle theVehicle = vehicleService.findById(vehicleId);
		
		if (theVehicle == null) {
			throw new RuntimeException("Vehicle id not found - " + vehicleId);
		}
		
		return theVehicle;
	}
	
	
	@PostMapping("/vehicles")
	public Vehicle addVehicle(@RequestBody Vehicle theVehicle) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theVehicle.setId(0);
		
		vehicleService.save(theVehicle);
		
		return theVehicle;
	}
	
		
	@PutMapping("/vehicles")
	public Vehicle updateVehicle(@RequestBody Vehicle theVehicle) {
		
		vehicleService.save(theVehicle);
		
		return theVehicle;
	}
	
	
	@DeleteMapping("/vehicles/{vehicleId}")
	public String deleteVehicle(@PathVariable int vehicleId) {
		
		Vehicle tempVehicle = vehicleService.findById(vehicleId);
		
		// throw exception if null
		
		if (tempVehicle == null) {
			throw new RuntimeException("Vehicle id not found - " + vehicleId);
		}
		
		vehicleService.deleteById(vehicleId);
		
		return "Deleted Vehicle id - " + vehicleId;
	}
	
}
