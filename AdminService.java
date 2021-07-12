package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Admin;

public interface AdminService {

	public List<Admin> findAll();
	
	public Admin findById(int theId);
	
	public void save(Admin theAdmin);
	
	public void deleteById(int theId);
}
