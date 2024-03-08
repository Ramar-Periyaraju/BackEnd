package com.healthcare.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.demo.Entity.Doctor;
import com.healthcare.demo.Service.DoctorService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService ;

    @CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/addDoctor")
public Doctor postDoctorDetails(@RequestBody Doctor doctor) {

    return doctorService.saveDetails(doctor);
}

@GetMapping("/test")

public String test(){

  return "success";
}

@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

}


