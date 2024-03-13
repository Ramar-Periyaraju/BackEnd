package com.healthcare.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.Entity.patient;


public interface PatientRepo extends JpaRepository<patient, Integer> {
  patient findByEmail(String email);
  patient findByUsername(String username);


}
