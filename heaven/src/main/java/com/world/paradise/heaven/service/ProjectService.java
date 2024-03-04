package com.world.paradise.heaven.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.paradise.heaven.project.Project;
import com.world.paradise.heaven.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	public List<Project> getAllProject() {
		return projectRepository.findAll();
				
	}

	public Optional<Project> getById(String id) {
		return projectRepository.findById(id);
	}

	public void addProject(Project project) {
		projectRepository.save(project);
		
	}

	public Project updateProject(Project project, int id) {
		Project pro = projectRepository.findProjectById(id);
		if (pro != null) {
			pro.setName(project.getName());
			pro.setAddress(project.getAddress());
			pro.setMobileno(project.getMobileno());
			return projectRepository.save(pro);
		}
		return null;
		
	}

	public void deleteAllProject() {
		projectRepository.deleteAll();
		
	}

	public void deleteById(String id) {
		projectRepository.deleteById(id);
		
	}

}
