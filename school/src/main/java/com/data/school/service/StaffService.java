package com.data.school.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.school.repository.StaffRepository;
import com.data.school.staff.Staff;

@Service
public class StaffService {
	
	@Autowired
	private StaffRepository repository;

	
	public List<Staff> getAllStaff() {
		return (List<Staff>) repository.findAll() ;
	}

	public Optional<Staff> getByStaff(int id) {
		return repository.findById(id);
	}

	public void createNewStaff(Staff staff) {
		repository.save(staff);
	}

	public Staff updateStaff(Staff staff, int id) {
		Staff s1 = repository.findStaffById(id);
		if (s1 != null) {
			s1.setName(staff.getName());
			s1.setAddress(staff.getAddress());
			s1.setSalary(staff.getSalary());
			return repository.save(s1);
		}
		return null;
		
	}

	public void removeAllStaff() {
		repository.deleteAll();
		
	}

	public void removeById(int id) {
		repository.deleteById(id);
	}

}
