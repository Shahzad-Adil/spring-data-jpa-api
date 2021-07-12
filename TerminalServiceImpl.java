package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TerminalRepository;
import com.example.demo.entity.Terminal;

@Service
public class TerminalServiceImpl implements TerminalService {



	private TerminalRepository terminalRepository;
	
	@Autowired
	public TerminalServiceImpl(TerminalRepository theTerminalRepository) {
		terminalRepository = theTerminalRepository;
	}
	
	@Override
	public List<Terminal> findAll() {
		return terminalRepository.findAll();
	}
	
	@Override
	public Terminal findById(int theId) {
		Optional<Terminal> result = terminalRepository.findById(theId);
		
		Terminal theTerminal = null;
		
		if (result.isPresent()) {
			theTerminal = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Terminal id - " + theId);
		}
		
		return theTerminal;
	}

	@Override
	public void save(Terminal theTerminal) {
		terminalRepository.save(theTerminal);
	}

	@Override
	public void deleteById(int theId) {
		terminalRepository.deleteById(theId);
	}


}
