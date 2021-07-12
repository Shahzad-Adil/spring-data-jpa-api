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

import com.example.demo.entity.Terminal;
import com.example.demo.service.TerminalService;


@RestController
@RequestMapping("/api")
public class TerminalRestController {


	private TerminalService terminalService;
	
	@Autowired
	public TerminalRestController(TerminalService theTerminalService) {
		terminalService = theTerminalService;
	}
	
	@GetMapping("/terminals")
	public List<Terminal> findAll() {
		return terminalService.findAll();
	}
	
	@GetMapping("/terminals/{terminalId}")
	public Terminal getTerminal(@PathVariable int terminalId) {
		
		Terminal theTerminal = terminalService.findById(terminalId);
		
		if (theTerminal == null) {
			throw new RuntimeException("Terminal id not found - " + terminalId);
		}
		
		return theTerminal;
	}
	
	
	@PostMapping("terminals")
	public Terminal addTerminal(@RequestBody Terminal theTerminal) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theTerminal.setId(0);
		
		terminalService.save(theTerminal);
		
		return theTerminal;
	}
	
		
	@PutMapping("/terminals")
	public Terminal updateTerminal(@RequestBody Terminal theTerminal) {
		
		terminalService.save(theTerminal);
		
		return theTerminal;
	}
	
	
	@DeleteMapping("/terminals/{terminalId}")
	public String deleteTerminal(@PathVariable int terminalId) {
		
		Terminal tempTerminal = terminalService.findById(terminalId);
		
		// throw exception if null
		
		if (tempTerminal == null) {
			throw new RuntimeException("Terminal id not found - " + terminalId);
		}
		
		terminalService.deleteById(terminalId);
		
		return "Deleted Terminal id - " + terminalId;
	}
	
}
