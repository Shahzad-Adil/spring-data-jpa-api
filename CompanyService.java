package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Company;


public interface CompanyService {

	public List<Company> findAll();
	
	public Company findById(int theId);
	
	public void save(Company theCompany);
	
	public void deleteById(int theId);
}
