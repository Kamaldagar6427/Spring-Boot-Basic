package com.data.school.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.school.service.StaffService;
import com.data.school.staff.Staff;

import jakarta.validation.Valid;

@RestController
public class StaffController {
	
	@Autowired
	private StaffService service;
	
	@GetMapping("/school")
	public List<Staff> getAllStaff(){
	   return (List<Staff>)service.getAllStaff();
	}
	
	@GetMapping("/school/{id}")
	public Optional<Staff> getByStaff(@PathVariable int id) {
		return service.getByStaff(id);
	}
	@PostMapping("/school")
	public void createNewStaff(@RequestBody @Valid Staff staff) {
		service.createNewStaff(staff);
	}
	@PutMapping("/school/{id}")
	public Staff upateStaff(@RequestBody @Valid Staff staff, @PathVariable int id) {
		return service.updateStaff(staff, id);
	}
	@DeleteMapping("/school") 
	public void removeAllStaff() {
		service.removeAllStaff();
	}
	@DeleteMapping("/school/{id}") 
	public void removeById(@PathVariable int id) {
		service.removeById(id);
	}

}
