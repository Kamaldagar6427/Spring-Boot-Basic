package com.ebit.company.worker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebit.company.worker.worker.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer>{

	Worker findTopicById(int id);

}
