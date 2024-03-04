package com.ebit.kamlesh.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ebit.kamlesh.files.Files;
import com.ebit.kamlesh.repository.FileRepository;

@Service
public class FileService {
	@Autowired
	private FileRepository fileRepository;


	public List<Files> getAllFiles() {
		 return fileRepository.findAll();
	}


	public Optional<Files> getById(String id) {
		return fileRepository.findById(id);
	}


	public void addFiles(Files file) {
		fileRepository.save(file);
		
	}


	public Files updateFiles(Files file, int id) {
		Files f1 = fileRepository.findFileById(id);
		if (f1 != null) {
			f1.setName(file.getName());
			f1.setAddress(file.getAddress());
			f1.setMobileno(file.getMobileno());
			return fileRepository.save(f1);
		}
		return null;
		
		
	}


	public void deleteAllFiles() {
		fileRepository.deleteAll();
		
	}


	public void deleteById(String id) {
		fileRepository.deleteById(id);
		
	}

}
