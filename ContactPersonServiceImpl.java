package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContactPersonRepository;
import com.example.demo.entity.ContactPerson;

@Service
public class ContactPersonServiceImpl implements ContactPersonService {

	
	private ContactPersonRepository contactPersonRepository;


	@Autowired
	public ContactPersonServiceImpl(ContactPersonRepository theContactPersonRepository) {
		contactPersonRepository = theContactPersonRepository;
	}
	
	@Override
	public List<ContactPerson> findAll() {
		return contactPersonRepository.findAll();
	}
	
	@Override
	public  ContactPerson findById(int theId) {
		Optional< ContactPerson> result = contactPersonRepository.findById(theId);
		
		 ContactPerson theContactPerson = null;
		
		if (result.isPresent()) {
			theContactPerson = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find ContactPerson id - " + theId);
		}
		
		return theContactPerson;
	}

	@Override
	public void save(ContactPerson theContactPerson) {
		contactPersonRepository.save(theContactPerson);
	}

	@Override
	public void deleteById(int theId) {
		contactPersonRepository.deleteById(theId);
	}

}
