package com.healthcare.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.Entity.appointment;

public interface AppointmentRepo extends JpaRepository<appointment, String> {

}
