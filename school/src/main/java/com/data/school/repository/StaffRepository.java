package com.data.school.repository;

import org.springframework.data.repository.CrudRepository;

import com.data.school.staff.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer> {

	Staff findStaffById(int id);

	

}
