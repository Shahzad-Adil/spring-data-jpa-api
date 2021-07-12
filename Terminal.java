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
@Table(name="terminal")
public class Terminal {

	//define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="t_id")
	private int id;
	
	@Column(name="t_name")
	private String name;
	
	@Column(name="t_description")
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="terminal", orphanRemoval = false ,
			cascade={CascadeType.ALL
			})
	@JsonBackReference(value="ter-veh")
	private List<Vehicle> vehicles ;
	
	
	//define constructor
	
	public Terminal() {
		
	}

	public Terminal(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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

	@Override
	public String toString() {
		return "Terminal [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
//	public void add(Vehicle theVehicle) {
//		
//		if(vehicles == null)
//			vehicles = new ArrayList<>();
//		
//		vehicles.add(theVehicle);
//		theVehicle.setTerminal(this);
//	}

	
}














