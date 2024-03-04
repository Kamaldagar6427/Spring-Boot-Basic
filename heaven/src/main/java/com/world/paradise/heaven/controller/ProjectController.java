package com.world.paradise.heaven.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.world.paradise.heaven.project.Project;
import com.world.paradise.heaven.service.ProjectService;

import jakarta.validation.Valid;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService ;
	
	@GetMapping("/projects")
	public List<Project> getAllProject(){
		return projectService.getAllProject();
	}
	@GetMapping("/projects/{id}")
	public Optional<Project> getById(@PathVariable String id) {
		return projectService.getById(id);
	}
	@PostMapping("/projects")
	public void addProject(@RequestBody @Valid Project project) {
		projectService.addProject(project);
	}
	@PutMapping("/projects/{id}")
	public Project updateProject(@RequestBody Project project, @PathVariable int id) {
		return projectService.updateProject(project, id);
	}
	@DeleteMapping("/projects")
	public void deleteAllProject() {
		projectService.deleteAllProject();
	}
	@DeleteMapping("/projects/{id}")
	public void deleteById(@PathVariable String id) {
		projectService.deleteById(id);
	}
}
