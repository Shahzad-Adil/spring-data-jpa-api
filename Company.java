package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="company")
public class Company {

	//define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comp_id")
	private int id;
	
	@Column(name="comp_name")
	private String name;
	
	@Column(name="comp_description")
	private String description;
	
	@Column(name="password")
	private String password;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="company",
			cascade={CascadeType.ALL
			})
	@JsonBackReference(value="com-con")
	private List<ContactPerson> contactPersons;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="company",
			cascade={CascadeType.ALL}
	)
	@JsonBackReference(value="com-veh")
	private List<Vehicle> vehicles ;
	
	 
	//define constructors
	
	public Company() {
		
	}
	
	
	public Company(String name, String description, String password) {
		super();
		this.name = name;
		this.description = description;
		this.password = password;
	}




	//define getters setters

	
	public int getId() {
		return id;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}


	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}


	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}


	public void setContactPersons(List<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	//define toString

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return String.format("Company [id=%s, name=%s, description=%s, password=%s]", id, name, description, password);
	}

	
	
	
//	public void add(ContactPerson contactPerson) {
//		
//		if(contactPersons == null)
//			contactPersons = new ArrayList<>();
//		
//		contactPersons.add(contactPerson);
//		contactPerson.setCompany(this);
//	}
//	
//	public void add(Vehicle vehicle) {
//		
//		if(vehicles == null)
//			vehicles = new ArrayList<>();
//		
//		vehicles.add(vehicle);
//		vehicle.setCompany(this);
//	}
	
}
















