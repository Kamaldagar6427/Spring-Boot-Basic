package com.ebit.kamlesh.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.kamlesh.files.Files;
import com.ebit.kamlesh.service.FileService;

import jakarta.validation.Valid;


@RestController
public class FileController {
	
	@Autowired
	private FileService fileService;

	@GetMapping("/files")
	public List<Files> getAllFiles() {
		return fileService.getAllFiles();
	}
	@GetMapping("/files/{id}")
	public Optional<Files> getById(@PathVariable String id) {
		return fileService.getById(id);
	}
	@PostMapping("/files")
	public void addFiles(@RequestBody @Valid Files file) {
		fileService.addFiles(file);
	}
	@PutMapping("/files/{id}")
	public Files updateFiles(@RequestBody Files file, @PathVariable int id) {
		return fileService.updateFiles(file, id);	
	}
	@DeleteMapping("/files")
	public void deleteAllFiles() {
		fileService.deleteAllFiles();
	}
	@DeleteMapping("/files/{id}")
	public void deleteById(@PathVariable String id) {
		fileService.deleteById(id);
	}
}
