package com.healthcare.demo.Entity;

import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;
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
@Table(name ="Patient")
@NoArgsConstructor
@AllArgsConstructor
public class patient {

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

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private LocalDate createdAt;

  @Column(name = "patientID")
  private String patientID;

  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }


  public String generatePatientID(String firstname, String lastname, String mobilenumber) {
    // Check if createdAt is null and handle it appropriately
    if (createdAt == null) {
      // Handle the case when createdAt is null, perhaps by throwing an exception or returning a default value
      return "CreatedAtIsNull";
    }

    // Get the first letter of the first name
    String firstLetterFirstName = firstname.substring(0, 1).toUpperCase();

    // Get the first letter of the last name
    String firstLetterLastName = lastname.substring(0, 1).toUpperCase();

    // Get the first 3 digits of the phone number
    String phoneDigits = mobilenumber.substring(0, 3);

    // Get the current date
    String currentDate = createdAt.toString().replace("-", "");

    // Concatenate all parts to form the userID
    String patientID = firstLetterFirstName + firstLetterLastName + phoneDigits + currentDate;

    return patientID;
  }
}
