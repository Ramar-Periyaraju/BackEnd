package com.healthcare.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.demo.Entity.Doctor;
import com.healthcare.demo.Repository.DoctorRepo;

@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepo doctorRepo;

    public Doctor saveDetails(Doctor doctor) { 
        return doctorRepo.save(doctor);

    }

}
