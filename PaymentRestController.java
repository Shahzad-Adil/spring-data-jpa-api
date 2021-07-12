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

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;



@RestController
@RequestMapping("/api")
public class PaymentRestController {


	private PaymentService paymentService;
	
	@Autowired
	public PaymentRestController(PaymentService thePaymentService) {
		paymentService = thePaymentService;
	}
	
	@GetMapping("/payments")
	public List<Payment> findAll() {
		return paymentService.findAll();
	}
	
	@GetMapping("/payments/{paymentId}")
	public Payment getPayment(@PathVariable int paymentId) {
		
		Payment thePayment = paymentService.findById(paymentId);
		
		if (thePayment == null) {
			throw new RuntimeException("Payment id not found - " + paymentId);
		}
		
		return thePayment;
	}
	
	
	@PostMapping("/payments")
	public Payment addPayment(@RequestBody Payment thePayment) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		thePayment.setId(0);
		
		paymentService.save(thePayment);
		
		return thePayment;
	}
	
		
	@PutMapping("/payments")
	public Payment updatePayment(@RequestBody Payment thePayment) {
		
		paymentService.save(thePayment);
		
		return thePayment;
	}
	
	
	@DeleteMapping("/payments/{paymentId}")
	public String deletePayment(@PathVariable int paymentId) {
		
		Payment tempPayment = paymentService.findById(paymentId);
		
		// throw exception if null
		
		if (tempPayment == null) {
			throw new RuntimeException("Payment id not found - " + paymentId);
		}
		
		paymentService.deleteById(paymentId);
		
		return "Deleted Payment id - " + paymentId;
	}
	
}
