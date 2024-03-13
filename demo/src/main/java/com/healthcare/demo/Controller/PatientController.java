package com.healthcare.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.demo.Entity.patient;
import com.healthcare.demo.Service.PatientService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class PatientController {

    @Autowired
    private PatientService patientservice ;

@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/api/v1/addPatient")
public ResponseEntity<?> postDetails(@RequestBody patient patient) {

    return patientservice.saveDetails(patient);
}

}
