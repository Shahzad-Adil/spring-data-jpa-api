package com.example.demo.entity;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="payment")
public class Payment {

	//define fields
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="payment_id")
		private int id;
		
		@Column(name="payment_time")
		private LocalDateTime payment_time;
		
		@Column(name="bill")
		private double bill;
		
		@Column(name="payment_description")
		private String description; 
		
		
		@ManyToOne
		@JoinColumn(name="cus_id")
//		@JsonIgnore
//		@JsonManagedReference(value="payment")
		private Customer customer;
		
//		@JsonIgnore
		@OneToOne (cascade= CascadeType.ALL)
		@JoinColumn(name="trip_id")
//		@JsonManagedReference(value="pay-tri")
		private Trip trip;
		
		
		//define constructor
		
		public Payment() {
			
		}

		public Payment(LocalDateTime payment_time, double bill, String description, Customer customer, Trip trip) {
			super();
			this.payment_time = payment_time;
			this.bill = bill;
			this.description = description;
			this.customer = customer;
			this.trip = trip;
		}
		
		
		//define getter setter


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public LocalDateTime getPayment_time() {
			return payment_time;
		}


		public void setPayment_time(LocalDateTime payment_time) {
			this.payment_time = payment_time;
		}


		public double getBill() {
			return bill;
		}


		public void setBill(double bill) {
			this.bill = bill;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public Customer getCustomer() {
			return customer;
		}


		public void setCustomer(Customer customer) {
			this.customer = customer;
		}


		public Trip getTrip() {
			return trip;
		}


		public void setTrip(Trip trip) {
			this.trip = trip;
		}
		
		
		//define toString

		@Override
		public String toString() {
			return "Payment [id=" + id + ", payment_time=" + payment_time + ", bill=" + bill + ", description="
					+ description + "]";
		}
		
		
		
		
}
