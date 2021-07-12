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

import com.example.demo.entity.Company;
import com.example.demo.service.CompanyService;


@RestController
@RequestMapping("/api")
public class CompanyRestController {


	private CompanyService companyService;
	
	@Autowired
	public CompanyRestController(CompanyService theCompanyService) {
		companyService = theCompanyService;
	}
	
	@GetMapping("/companies")
	public List<Company> findAll() {
		return companyService.findAll();
	}
	
	@GetMapping("/companies/{companyId}")
	public Company getCompany(@PathVariable int companyId) {
		
		Company theCompany = companyService.findById(companyId);
		
		if (theCompany == null) {
			throw new RuntimeException("Company id not found - " + theCompany);
		}
		
		return theCompany;
	}
	
	
	@PostMapping("/companies")
	public Company addCompany(@RequestBody Company theCompany) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theCompany.setId(0);
		
		companyService.save(theCompany);
		
		return theCompany;
	}
	
		
	@PutMapping("/companies")
	public Company updateCompany(@RequestBody Company theCompany) {
		
		companyService.save(theCompany);
		
		return theCompany;
	}
	
	
	@DeleteMapping("/companies/{companyId}")
	public String deleteCompany(@PathVariable int companyId) {
		
		Company tempCompany = companyService.findById(companyId);
		
		// throw exception if null
		
		if (tempCompany == null) {
			throw new RuntimeException("Company id not found - " + companyId);
		}
		
		companyService.deleteById(companyId);
		
		return "Deleted Company id - " + companyId;
	}
	
}
