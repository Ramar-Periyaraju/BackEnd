package com.healthcare.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.Entity.appointment; // Adjust import to use the entity class

public interface AppointmentRepo extends JpaRepository<appointment, Integer> {

}
