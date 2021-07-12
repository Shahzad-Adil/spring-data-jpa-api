package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CompanyRepository;
import com.example.demo.entity.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	
	private CompanyRepository companyRepository;
	
	@Autowired
	public CompanyServiceImpl(CompanyRepository theCompanyRepository) {
		companyRepository = theCompanyRepository;
	}
	
	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}
	
	@Override
	public Company findById(int theId) {
		Optional<Company> result = companyRepository.findById(theId);
		
		Company theCompany = null;
		
		if (result.isPresent()) {
			theCompany = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Company id - " + theId);
		}
		
		return theCompany;
	}

	@Override
	public void save(Company theCompany) {
		companyRepository.save(theCompany);
	}

	@Override
	public void deleteById(int theId) {
		companyRepository.deleteById(theId);
	}
}
