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

import com.example.demo.entity.Feedback;
import com.example.demo.service.FeedbackService;


@RestController
@RequestMapping("/api")
public class FeedbackRestController {

	private FeedbackService feedbackService;
	
	@Autowired
	public FeedbackRestController(FeedbackService theFeedbackService) {
		feedbackService = theFeedbackService;
	}
	
	@GetMapping("/feedbacks")
	public List<Feedback> findAll() {
		return feedbackService.findAll();
	}
	
	@GetMapping("/feedbacks/{feedbackId}")
	public Feedback getFeedback(@PathVariable int feedbackId) {
		
		Feedback theFeedback = feedbackService.findById(feedbackId);
		
		if (theFeedback == null) {
			throw new RuntimeException("Feedback id not found - " + feedbackId);
		}
		
		return theFeedback;
	}
	
	
	@PostMapping("/feedbacks")
	public Feedback addFeedback(@RequestBody Feedback theFeedback) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theFeedback.setId(0);
		
		feedbackService.save(theFeedback);
		
		return theFeedback;
	}
	
		
	@PutMapping("/feedbacks")
	public Feedback updateFeedback(@RequestBody Feedback theFeedback) {
		
		feedbackService.save(theFeedback);
		
		return theFeedback;
	}
	
	
	@DeleteMapping("/feedbacks/{feedbackId}")
	public String deleteFeedback(@PathVariable int feedbackId) {
		
		Feedback tempFeedback = feedbackService.findById(feedbackId);
		
		// throw exception if null
		
		if (tempFeedback == null) {
			throw new RuntimeException("Feedback id not found - " + feedbackId);
		}
		
		feedbackService.deleteById(feedbackId);
		
		return "Deleted Feedback id - " + feedbackId;
	}
	
}
