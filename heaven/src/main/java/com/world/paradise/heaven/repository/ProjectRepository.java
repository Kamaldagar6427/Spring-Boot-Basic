package com.world.paradise.heaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.world.paradise.heaven.project.Project;

public interface ProjectRepository extends JpaRepository<Project, String>{

	Project findProjectById(int id);

}
