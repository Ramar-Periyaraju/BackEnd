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
@Table(name ="User")
@NoArgsConstructor
@AllArgsConstructor

public class User {

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
    private String email;

    @Column(name = "mobilenumber")
    private String mobilenumber;

}
