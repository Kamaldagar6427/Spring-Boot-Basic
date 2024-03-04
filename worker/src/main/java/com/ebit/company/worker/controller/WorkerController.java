package com.ebit.company.worker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.company.worker.service.WorkerService;
import com.ebit.company.worker.worker.Worker;

import jakarta.validation.Valid;

@RestController
public class WorkerController {
	
	@Autowired
	private WorkerService topicService;
	
	@GetMapping("/topics")
	public List<Worker> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@GetMapping("/topics/{id}")
	public Optional<Worker> getTopic(@PathVariable int id) {
		return topicService.getTopic(id);
	}
	@PostMapping("/topics")
	public Worker addTopic(@RequestBody @Valid Worker topic) {
		return topicService.addTopic(topic);
	}
	
	@PutMapping("/topics/{id}")
	public Worker updateTopic(@RequestBody @Valid Worker topic, @PathVariable int id) {
		return topicService.updateTopic(topic, id);
	}
	@DeleteMapping("/topics/{id}")
	public void deleteTopic(@PathVariable int id) {
		topicService.deleteTopic(id);
	}
	@DeleteMapping("/topics")
	public void deleteAllTopics() {
		topicService.deleteAllTopics();
	}
	
}	
	
