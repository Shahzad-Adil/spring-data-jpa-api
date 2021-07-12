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

import com.example.demo.entity.Driver;
import com.example.demo.service.DriverService;


@RestController
@RequestMapping("/api")
public class DriverRestController {


	private DriverService driverService;
	
	@Autowired
	public DriverRestController(DriverService theDriverService) {
		driverService = theDriverService;
	}
	
	@GetMapping("/drivers")
	public List<Driver> findAll() {
		return driverService.findAll();
	}
	
	@GetMapping("/drivers/{driverId}")
	public Driver getDriver(@PathVariable int driverId) {
		
		Driver theDriver = driverService.findById(driverId);
		
		if (theDriver == null) {
			throw new RuntimeException("Driver id not found - " + driverId);
		}
		
		return theDriver;
	}
	
	
	@PostMapping("/drivers")
	public Driver addDriver(@RequestBody Driver theDriver) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theDriver.setId(0);
		
		driverService.save(theDriver);
		
		return theDriver;
	}
	
		
	@PutMapping("/drivers")
	public Driver updateDriver(@RequestBody Driver theDriver) {
		
		driverService.save(theDriver);
		
		return theDriver;
	}
	
	
	@DeleteMapping("/drivers/{driverId}")
	public String deleteDriver(@PathVariable int driverId) {
		
		Driver tempDriver = driverService.findById(driverId);
		
		// throw exception if null
		
		if (tempDriver == null) {
			throw new RuntimeException("Driver id not found - " + driverId);
		}
		
		driverService.deleteById(driverId);
		
		return "Deleted Driver id - " + driverId;
	}
	
}
