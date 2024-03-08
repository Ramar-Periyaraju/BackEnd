package com.healthcare.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.healthcare.demo.Entity.Doctor;
import com.healthcare.demo.Repository.DoctorRepo;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Doctor saveDetails(Doctor doctor) {
      String encryptedPassword = passwordEncoder.encode(doctor.getPassword());
      doctor.setPassword(encryptedPassword);
        return doctorRepo.save(doctor);

    }

    public List<Doctor> getAllDoctors() {
      return doctorRepo.findAll();
  }

}
