package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Feedback;


public interface FeedbackService {

	public List<Feedback> findAll();
	
	public Feedback findById(int theId);
	
	public void save(Feedback theFeedback);
	
	public void deleteById(int theId);
}
