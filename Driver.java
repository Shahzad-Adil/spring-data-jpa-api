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
@Table(name="driver") 
public class Driver {

	//define fields
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="driver_id")
		private int id;
		
		@Column(name="driver_name")
		private String name;
		
		@Column(name="driver_user_name")
		private String userName;
		
		@Column(name="driver_password")
		private String password;
		
		@Column(name="driver_email")
		private String email;
		
		@Column(name="driver_cnic")
		private String cnic;
		
		@Column(name="driver_mobile_number")
		private String phone;
		
		@Column(name="driver_description")
		private String description;

		@Column(name="driver_on_trip")
		private boolean driver_on_trip;

		@OneToMany(fetch=FetchType.LAZY, mappedBy="driver",
				cascade={CascadeType.ALL
				})
		@JsonBackReference(value="dri-tri")
		private List<Trip> trips ;
		
		//define constructor
		
		public Driver() {
			
		}
			
		public Driver(String name, String userName, String password, String email, String cnic, String phone,
				String description, boolean driver_on_trip) {
			super();
			this.name = name;
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.cnic = cnic;
			this.phone = phone;
			this.description = description;
			this.driver_on_trip = driver_on_trip;
		}
		
		
	// define Getters Setters

		public int getId() {
			return id;
		}

		public List<Trip> getTrips() {
			return trips;
		}


		public void setTrips(List<Trip> trips) {
			this.trips = trips;
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


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getCnic() {
			return cnic;
		}


		public void setCnic(String cnic) {
			this.cnic = cnic;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public boolean isDriver_on_trip() {
			return driver_on_trip;
		}


		public void setDriver_on_trip(boolean driver_on_trip) {
			this.driver_on_trip = driver_on_trip;
		}
		
		
		
		//define toString

		@Override
		public String toString() {
			return "Driver [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password
					+ ", email=" + email + ", cnic=" + cnic + ", phone=" + phone + ", description=" + description
					+ ", driver_on_trip=" + driver_on_trip + "]";
		}
		
		
//		public void add(Trip trip) {
//			
//			if(trips == null)
//				trips = new ArrayList<>();
//			
//			trips.add(trip);
//			trip.setDriver(this);
//		}
		
}













