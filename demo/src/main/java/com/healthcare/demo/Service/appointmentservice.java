// Service
package com.healthcare.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.demo.Entity.appointment;
import com.healthcare.demo.Repository.AppointmentRepo;

@Service
public class appointmentservice {

   @Autowired
   private AppointmentRepo appointmentRepo;

   public appointment saveAppointmentDetails(appointment appointment) {
      return appointmentRepo.save(appointment);
   }
}
