package com.ebit.work.empolyee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebit.work.empolyee.module.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findEmployeeById(int id);

}
