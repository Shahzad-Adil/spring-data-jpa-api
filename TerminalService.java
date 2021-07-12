package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Terminal;


public interface TerminalService {

	public List<Terminal> findAll();
	
	public Terminal findById(int theId);
	
	public void save(Terminal theTerminal);
	
	public void deleteById(int theId);
}
