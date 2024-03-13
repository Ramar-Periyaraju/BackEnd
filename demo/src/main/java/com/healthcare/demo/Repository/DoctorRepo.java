package com.healthcare.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.Entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

  Optional<Doctor> findByEmailaddress(String email);


  List<Doctor> findAll();

}
