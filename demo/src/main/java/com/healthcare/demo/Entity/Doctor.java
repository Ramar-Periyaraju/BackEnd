package com.healthcare.demo.Entity;


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

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "emailaddress")
    private String emailaddress;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "country")
    private String country;


}
