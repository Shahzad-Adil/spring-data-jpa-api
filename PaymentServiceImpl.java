package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PaymentRepository;
import com.example.demo.entity.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {


	private PaymentRepository paymentRepository;
	
	@Autowired
	public PaymentServiceImpl(PaymentRepository thePaymentRepository) {
		paymentRepository = thePaymentRepository;
	}
	
	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}
	
	@Override
	public Payment findById(int theId) {
		Optional<Payment> result = paymentRepository.findById(theId);
		
		Payment thePayment = null;
		
		if (result.isPresent()) {
			thePayment = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Payment id - " + theId);
		}
		
		return thePayment;
	}

	@Override
	public void save(Payment thePayment) {
		paymentRepository.save(thePayment);
	}

	@Override
	public void deleteById(int theId) {
		paymentRepository.deleteById(theId);
	}


}
