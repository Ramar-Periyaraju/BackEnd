package com.healthcare.demo.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.healthcare.demo.Entity.patient;
import com.healthcare.demo.Repository.PatientRepo;


import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class PatientService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PatientRepo patientRepo;

    public patient findPatientByEmail(String email) {
      return patientRepo.findByEmail(email);
  }

    public ResponseEntity<?> saveDetails(patient patient) {

      patient existingPatient = patientRepo.findByEmail(patient.getEmail());
      if (existingPatient != null) {
        return ResponseEntity.badRequest().body("{\"error\": \"Patient with email " + patient.getEmail() + " already exists\"}");
      }

        String encryptedPassword = passwordEncoder.encode(patient.getPassword());
        patient.setPassword(encryptedPassword);
       patient.setCreatedAt(LocalDate.now()); // Set current date

        String patientID = patient.generatePatientID(patient.getFirstname(), patient.getLastname(), patient.getMobilenumber());
        patient.setPatientID(patientID);
        patientRepo.save(patient);
        return ResponseEntity.ok("{\"message\": \"Patient registered successfully\"}");


    }

    public String getEncryptedPasswordByEmail(String email) {
        patient patient = patientRepo.findByEmail(email);
        if (patient != null) {
            return patient.getPassword(); // Assuming the password is stored as a String in the database
        }
        return null;
    }

    public boolean verifyPassword(String rawPassword, String encryptedPassword) {
        return passwordEncoder.matches(rawPassword, encryptedPassword);
    }
}
