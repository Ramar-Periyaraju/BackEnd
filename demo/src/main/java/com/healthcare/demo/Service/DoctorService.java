package com.healthcare.demo.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;


import com.healthcare.demo.Entity.Doctor;
import com.healthcare.demo.Repository.DoctorRepo;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;


@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<Object> saveDetails(Doctor doctor) {

        Optional<Doctor> existingDoctor = doctorRepo.findByEmailaddress(doctor.getEmailaddress());

        String encryptedPassword = passwordEncoder.encode(doctor.getPassword());
         if (existingDoctor.isPresent()) {
        // If a doctor with the same email exists, return an error response
        String errorMessage = "Doctor with email " + doctor.getEmailaddress() + " already exists";

                    Map<String, Object> response = new HashMap<>();
                    response.put("error", errorMessage);


                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
                  }

        doctor.setPassword(encryptedPassword);
          Doctor savedDoctor = doctorRepo.save(doctor);

          return ResponseEntity.ok(savedDoctor);

      }

    public List<Doctor> getAllDoctors() {
      return doctorRepo.findAll();
  }

}
