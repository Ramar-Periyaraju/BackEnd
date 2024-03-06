package com.healthcare.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.Entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {


    
} 