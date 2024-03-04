package com.ebit.work.empolyee.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.work.empolyee.module.Employee;
import com.ebit.work.empolyee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public void getById(@PathVariable int id) {
        service.getById(id);
	}
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody @Valid Employee employee) {
		return service.createEmployee(employee);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmpolyee(@RequestBody @Valid Employee employee, @PathVariable @Valid int id) {
		return service.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/employee/{id}")
	public void removeById(@PathVariable int id) {
		service.removeById(id);
	}
	
	@DeleteMapping("/employee") 
	public void removeAllEmployee() {
		service.removeAllEmployee();
	}
	
}
