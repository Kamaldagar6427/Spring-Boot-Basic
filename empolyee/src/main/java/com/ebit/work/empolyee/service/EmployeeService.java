package com.ebit.work.empolyee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebit.work.empolyee.module.Employee;
import com.ebit.work.empolyee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	public void getById(int id) {
		repository.findById(id);
	}

	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee updateEmployee(Employee employee, int id) {
		Employee emp = repository.findEmployeeById(id);
		if (emp != null) {
			emp.setName(employee.getName());
			emp.setAddress(employee.getAddress());
			emp.setMobileNo(employee.getMobileNo());
			return repository.save(emp);
		}
		return null;
	}

	public void removeById(int id) {
		repository.deleteById(id);
	}

	public void removeAllEmployee() {
		repository.deleteAll();
		
	}

}
 