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

import com.example.demo.entity.ContactPerson;
import com.example.demo.service.ContactPersonService;


@RestController
@RequestMapping("/api")
public class ContactPersonRestController {

	

	private ContactPersonService contactPersonService;
	
	@Autowired
	public ContactPersonRestController(ContactPersonService theContactPersonService) {
		contactPersonService = theContactPersonService;
	}
	
	@GetMapping("/contactpersons")
	public List<ContactPerson> findAll() {
		return contactPersonService.findAll();
	}
	
	@GetMapping("/contactpersons/{contactpersonId}")
	public ContactPerson getContactPerson(@PathVariable int contactpersonId) {
		
		ContactPerson theContactPerson = contactPersonService.findById(contactpersonId);
		
		if (theContactPerson == null) {
			throw new RuntimeException("theContactPerson id not found - " + contactpersonId);
		}
		
		return theContactPerson;
	}
	
	
	@PostMapping("/contactpersons")
	public ContactPerson addContactPerson(@RequestBody ContactPerson theContactPerson) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theContactPerson.setId(0);
		
		contactPersonService.save(theContactPerson);
		
		return theContactPerson;
	}
	
		
	@PutMapping("/contactpersons")
	public ContactPerson updateContactPerson(@RequestBody ContactPerson theContactPerson) {
		
		contactPersonService.save(theContactPerson);
		
		return theContactPerson;
	}
	
	
	@DeleteMapping("/contactpersons/{contactpersonId}")
	public String deleteContactPerson(@PathVariable int contactpersonId) {
		
		ContactPerson tempContactPerson = contactPersonService.findById(contactpersonId);
		
		// throw exception if null
		
		if (tempContactPerson == null) {
			throw new RuntimeException("tempContactPerson id not found - " + contactpersonId);
		}
		
		contactPersonService.deleteById(contactpersonId);
		
		return "Deleted tempContactPerson id - " + contactpersonId;
	}
	
}
