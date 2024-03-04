package com.ebit.kamlesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ebit.kamlesh.files.Files;

public interface FileRepository extends JpaRepository<Files, String > {

	Files findFileById(int id);

	

		
	}
