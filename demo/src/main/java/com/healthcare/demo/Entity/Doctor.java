package com.healthcare.demo.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name ="Doctor")
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;


    @Column(name = "emailaddress")
    private String emailaddress;

    @Column(name = "mobilenumber")
    private String mobilenumber;


    @Column(name = "dateofbirth")
    private LocalDate dateofbirth;

    @Column(name = "specialization")
    private LocalDate specialization;

    @Column(name = "country")
    private LocalDate country;

    
}
