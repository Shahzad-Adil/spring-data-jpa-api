package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CompanyRepository;
import com.example.demo.dao.DriverRepository;
import com.example.demo.entity.Company;
import com.example.demo.entity.Driver;

@Service
public class DriverServiceImpl implements DriverService {



	private DriverRepository driverRepository;
	
	@Autowired
	public DriverServiceImpl(DriverRepository theDriverRepository) {
		driverRepository = theDriverRepository;
	}
	
	@Override
	public List<Driver> findAll() {
		return driverRepository.findAll();
	}
	
	@Override
	public Driver findById(int theId) {
		Optional<Driver> result = driverRepository.findById(theId);
		
		Driver theDriver = null;
		
		if (result.isPresent()) {
			theDriver = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Driver id - " + theId);
		}
		
		return theDriver;
	}

	@Override
	public void save(Driver theDriver) {
		driverRepository.save(theDriver);
	}

	@Override
	public void deleteById(int theId) {
		driverRepository.deleteById(theId);
	}


}
