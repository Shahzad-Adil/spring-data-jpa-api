package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FeedbackRepository;
import com.example.demo.entity.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService {



	private FeedbackRepository feedbackRepository;
	
	@Autowired
	public FeedbackServiceImpl(FeedbackRepository theFeedbackRepository) {
		feedbackRepository = theFeedbackRepository;
	}
	
	@Override
	public List<Feedback> findAll() {
		return feedbackRepository.findAll();
	}
	
	@Override
	public Feedback findById(int theId) {
		Optional<Feedback> result = feedbackRepository.findById(theId);
		
		Feedback theFeedback = null;
		
		if (result.isPresent()) {
			theFeedback = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Feedback id - " + theId);
		}
		
		return theFeedback;
	}

	@Override
	public void save(Feedback theFeedback) {
		feedbackRepository.save(theFeedback);
	}

	@Override
	public void deleteById(int theId) {
		feedbackRepository.deleteById(theId);
	}


}
