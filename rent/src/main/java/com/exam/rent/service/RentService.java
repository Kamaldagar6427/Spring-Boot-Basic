package com.exam.rent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.rent.entity.Rent;
import com.exam.rent.repository.RentRepository;

@Service
public class RentService {
	@Autowired
	private RentRepository rentRepository;

	public List<Rent> getAllRents() {
		return rentRepository.findAll();
	}

	public Optional<Rent> getById(String id) {
		return rentRepository.findById(id);
	}

	public void addRents(Rent rent) {
		rentRepository.save(rent);
		
	}

	public Rent updateRents(Rent rent, int id) {
		Rent r1 = rentRepository.findRentById(id);
		if (r1 != null) {
			r1.setName(rent.getName());
			r1.setMoney(rent.getMoney());
			return rentRepository.save(r1);
		}
		return null;
		
	}

	public void deleteAllRent() {
		rentRepository.deleteAll();
		
	}

	public void deleteById(String id) {
		rentRepository.deleteById(id);
		
	}

}
