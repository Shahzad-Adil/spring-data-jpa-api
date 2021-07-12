package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminRepository;
import com.example.demo.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	

private AdminRepository employeeRepository;
	
	@Autowired
	public AdminServiceImpl(AdminRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	public List<Admin> findAll() {
		return employeeRepository.findAll();
	}

	public Admin findById(int theId) {
		Optional<Admin> result = employeeRepository.findById(theId);
		
		Admin theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	public void save(Admin theEmployee) {
		employeeRepository.save(theEmployee);
	}

	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
