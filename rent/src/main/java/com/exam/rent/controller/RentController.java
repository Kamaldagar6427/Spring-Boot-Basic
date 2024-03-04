package com.exam.rent.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.rent.entity.Rent;
import com.exam.rent.service.RentService;

import jakarta.validation.Valid;

@RestController
public class RentController {
	@Autowired
	private RentService rentService;
	
	@GetMapping("/rents")
	public List<Rent> getAllRents() {
		return rentService.getAllRents();
	}
	@GetMapping("/rents/{id}")
	public Optional<Rent> getById(@PathVariable String id) {
		return rentService.getById(id);
	}
	@PostMapping("/rents")
	public void addRents(@RequestBody @Valid Rent rent) {
		rentService.addRents(rent);
	}
	@PutMapping("/rents/{id}")
	public void updateRents(@RequestBody Rent rent, @PathVariable int id ) {
		rentService.updateRents(rent, id);
	}
	@DeleteMapping("/rents")
	public void deleteAllRent() {
		rentService.deleteAllRent();
	}
	@DeleteMapping("/rents/{id}")
	public void deleteById(@PathVariable String id) {
		rentService.deleteById(id);
	}

}
