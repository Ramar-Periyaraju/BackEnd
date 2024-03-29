package com.healthcare.demo.Entity;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name ="Appointment")
@NoArgsConstructor
@AllArgsConstructor

public class appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.healthcare.demo.util.CustomIdGenerator")
    @Column(name = "ID")
    private String id;

  @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "addressline1")
    private String addressline1;

    @Column(name = "addressline2")
    private String addressline2;

    @Column(name = "addressline3")
    private String addressline3;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;


    @Column(name = "pincode")
    private String pincode;

    @Column(name = "country")
    private String country;

    @Column(name = "appointmenttype")
    private String appointmenttype;

    @Column(name = "IssueDesc")
    private String IssueDesc;

    public String getId() {
      return id;
  }

  public void setId(String id) {
      this.id = id;
  }

}
