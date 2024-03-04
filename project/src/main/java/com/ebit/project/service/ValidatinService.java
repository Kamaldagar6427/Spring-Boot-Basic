package com.ebit.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebit.project.model.User;
import com.ebit.project.repo.ValidationRepo;
import com.ebit.project.serviceInterface.serviceInterface;

import jakarta.validation.Valid;

@Service
public class ValidatinService implements serviceInterface {

	@Autowired
	private ValidationRepo myRepo;

	@Override
	public List<User> getData() {
		return myRepo.findAll();
	}

	@Override
	public User addData(@Valid User user) {
		return myRepo.save(user);
	}

	@Override
	public User updateData(int id, User user) {
		User data = myRepo.findUserById(id);
		
				if (data != null) {
					data.setName(user.getName());
					data.setEmail(user.getEmail());
					data.setMobileno(user.getMobileno());
					data.setAge(user.getAge());
				}
				return myRepo.save(data);
	}

	@Override
	public String deleteDataById(int id) {
		myRepo.deleteById(id);
		return "data deleted";
	}


//
//	public User addData(User user) {
//		return myRepo.save(user);
//	}
//
//	public User updateData(int id, User user) {
//		User data = myRepo.findUserById(id);
//
//		if (data != null) {
//			data.setName(user.getName());
//			data.setEmail(user.getEmail());
//			data.setMobileno(user.getMobileno());
//			data.setAge(user.getAge());
//		}
//		return myRepo.save(data);
//	}
//
//	public String deleteAllData() {
//		myRepo.deleteAll();
//		return "data deleted";
//	}
//
//	public String deleteDataById(int id) {
//		myRepo.deleteById(id);
//		return "data deleted";
//
//	}
//
//	public List<User> enterAllData(List<User> user) {
//		return myRepo.saveAll(user);
//	}

}
