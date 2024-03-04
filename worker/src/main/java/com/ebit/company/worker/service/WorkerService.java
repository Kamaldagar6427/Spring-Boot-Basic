package com.ebit.company.worker.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ebit.company.worker.repository.WorkerRepository;
import com.ebit.company.worker.worker.Worker;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;

	public List<Worker> getAllTopics() {
		return repository.findAll();
	}

	public Optional<Worker> getTopic(int id) {
		return repository.findById(id);
	}

	public Worker addTopic(Worker topic) {
		return repository.save(topic);
		
		
	}

	public Worker updateTopic(Worker topic, int id) {
		Worker work = repository.findTopicById(id);
		if (work != null) {
			work.setName(topic.getName());
			work.setAddress(topic.getAddress());
			work.setMobile(topic.getMobile());
			return repository.save(work);
		}
		return null;
		
	}

	public void deleteTopic(int id) {
		repository.deleteById(id);
		
	}

	public void deleteAllTopics() {
		repository.deleteAll();
		
	}

	
}
