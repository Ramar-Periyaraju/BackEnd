package com.healthcare.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.Entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

  List<Doctor> findAll();

}
