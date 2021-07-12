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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
 
@Entity
@Table(name="vehicle")
public class Vehicle {

	//define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="v_id")
	private int id;
	
	@Column(name="v_reg_no")
	private String v_reg_no;
	
	@Column(name="model_number")
	private String modelNumber;
	
	@Column(name="category")
	private String category;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="meter_reading")
	private double meter_reading;
	
	@Column(name="v_make")
	private String v_make;
	
	@Column(name="v_description")
	private String v_description;
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="comp_id")
//	@JsonManagedReference(value="veh-com")
	private Company company;
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="t_id")
//	@JsonManagedReference(value="ter-veh")
	private Terminal terminal;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="vehicle",
			cascade={CascadeType.ALL
			})
	@JsonBackReference(value="veh-fee")
	private List<Feedback> feedbacks ;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="vehicle",
			cascade={CascadeType.ALL
			})
	@JsonBackReference(value="veh-tri")
	private List<Trip> trips ;
	
	//define constructor
	
	public Vehicle() {
		
	}

	public Vehicle(String v_reg_no, String modelNumber, String category, boolean status, double meter_reading,
			String v_make, String v_description, Company company, Terminal terminal) {
		super();
		this.v_reg_no = v_reg_no;
		this.modelNumber = modelNumber;
		this.category = category;
		this.status = status;
		this.meter_reading = meter_reading;
		this.v_make = v_make;
		this.v_description = v_description;
		this.company = company;
		this.terminal = terminal;
	}
	
	
	//define getter setter

	public String getV_reg_no() {
		return v_reg_no;
	}
	
	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}


	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}


	public void setV_reg_no(String v_reg_no) {
		this.v_reg_no = v_reg_no;
	}


	public String getModelNumber() {
		return modelNumber;
	}


	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public double getMeter_reading() {
		return meter_reading;
	}


	public void setMeter_reading(double meter_reading) {
		this.meter_reading = meter_reading;
	}


	public String getV_make() {
		return v_make;
	}


	public void setV_make(String v_make) {
		this.v_make = v_make;
	}


	public String getV_description() {
		return v_description;
	}


	public void setV_description(String v_description) {
		this.v_description = v_description;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Terminal getTerminal() {
		return terminal;
	}


	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	//define toString

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", v_reg_no=" + v_reg_no + ", modelNumber=" + modelNumber + ", category="
				+ category + ", status=" + status + ", meter_reading=" + meter_reading + ", v_make=" + v_make
				+ ", v_description=" + v_description + "]";
	}

	
//	public void add(Feedback feedback) {
//		
//		if(feedbacks == null)
//			feedbacks = new ArrayList<>();
//		
//		feedbacks.add(feedback);
//		feedback.setVehicle(this);
//	}
//	
//	
//	public void add(Trip trip) {
//		
//		if(trips == null)
//			trips = new ArrayList<>();
//		
//		trips.add(trip);
//		trip.setVehicle(this);
//	}
	
}












