// Controller
package com.healthcare.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.demo.Entity.appointment;
import com.healthcare.demo.Service.appointmentservice;

@RestController
public class AppointmentController {

   @Autowired
   private appointmentservice appointmentService;

   @CrossOrigin(origins = "http://localhost:4200")
   @PostMapping("/addappointment")
   public appointment postappointmentDetails(@RequestBody appointment appointment) {
      return appointmentService.saveAppointmentDetails(appointment);
   }
}
