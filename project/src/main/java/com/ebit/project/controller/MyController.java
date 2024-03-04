package com.ebit.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.project.model.User;
import com.ebit.project.serviceInterface.serviceInterface;

import jakarta.validation.Valid;

@RestController
public class MyController {
	
	@Autowired
	private serviceInterface homeService;
	
	@GetMapping("/user")
	public List<User> getData(){
		return homeService.getData();
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addData(@RequestBody @Valid User user) {
		return new ResponseEntity<>( homeService.addData(user), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/user/{id}")
	public String updateData(@PathVariable int id, @RequestBody User user) {
		homeService.updateData(id,user);
		return "Data updated";
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteData(@PathVariable int id) {
		homeService.deleteDataById(id);
		return "Data deleted at id" + id;
	}

}
