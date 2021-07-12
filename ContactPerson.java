package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="contact_person") 
public class ContactPerson {

	//define fields
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="c_id")
		private int id;
		
		@Column(name="c_name")
		private String name;
		
		@Column(name="c_email")
		private String email;
		
		@Column(name="c_cnic")
		private String cnic;
		
		@Column(name="c_mobile_number")
		private String phone;
		
		@Column(name="c_description")
		private String description;

//		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="comp_id")
		//@JsonManagedReference(value="com-con")
		private Company company;

		
		//define constructors
		
		public ContactPerson() {
			
		}
		
		public ContactPerson(String name, String email, String cnic, String phone, String description, Company company
				) {
			super();
			this.name = name;
			this.email = email;
			this.cnic = cnic;
			this.phone = phone;
			this.description = description;
			this.company = company;
		}



		//define Getters Setters
		
		public int getId() {
			return id;
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


		public Company getCompany() {
			return company;
		}


		public void setCompany(Company company) {
			this.company = company;
		}



//		define toString
		
		@Override
		public String toString() {
			return "ContactPerson [id=" + id + ", name=" + name + ", email=" + email + ", cnic=" + cnic + ", phone="
					+ phone + ", description=" + description +  "]";
		}
		
		

		
		
}
