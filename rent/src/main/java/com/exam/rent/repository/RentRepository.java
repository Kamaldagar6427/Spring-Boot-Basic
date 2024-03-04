package com.exam.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.rent.entity.Rent;

public interface RentRepository extends JpaRepository<Rent, String> {

	Rent findRentById(int id);

}
