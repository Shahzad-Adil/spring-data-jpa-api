package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ContactPerson;


public interface ContactPersonService {

	public List<ContactPerson> findAll();
	
	public ContactPerson findById(int theId);
	
	public void save(ContactPerson theContactPerson);
	
	public void deleteById(int theId);
}
