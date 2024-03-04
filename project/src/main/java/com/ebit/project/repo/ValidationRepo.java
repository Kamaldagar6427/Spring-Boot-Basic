package com.ebit.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ebit.project.model.User;

@Repository
public interface ValidationRepo extends JpaRepository<User, Integer>{

	User findUserById(int id);

}
