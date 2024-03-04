package com.excel.myproject.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.excel.myproject.entity.User;
import com.excel.myproject.repository.UserRepository;

@Service
public class FileServiceImpl implements FileService {
    
    @Autowired
    private UserRepository repository;

    @Override
    public boolean hasCsvFormat(MultipartFile file) {
        String type = "text/csv"; // Corrected to lowercase "text/csv"
        return type.equals(file.getContentType());
    }

    @Override
    public void processAndSaveData(MultipartFile file) {
        try {
            List<User> users = csvToUser(file.getInputStream());
            repository.saveAll(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> csvToUser(InputStream inputStream) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            List<User> users = new ArrayList<>();
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get("name");
                String price = csvRecord.get("price");
                // No need to retrieve "index" if it's not present in the CSV file
                if (name != null && price != null) {
                    // Add logging to check the contents of the CSV record
                    System.out.println("Name: " + name + ", Price: " + price);
                    // Create User object and add to the list
                    User user = new User(5000, name, price);
                    users.add(user);
                } else {
                    // Handle empty or null fields
                    System.out.println("Skipping record due to missing fields: " + csvRecord);
                }
            }
            return users;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList(); // Return empty list on error
        }
    }
}
