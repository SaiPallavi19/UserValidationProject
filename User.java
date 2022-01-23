package com.javacodegeeks.examples.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
 
import com.fasterxml.jackson.annotation.JsonFormat;
 
@Entity
@Table(name="User")
public class User {
 
    @Id
    @Min(value = 1, message="id should not be null and should be atleast 1 digit")
    @Max(value = 10,message="id should not increase more than 10 digits")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
     
    @NotEmpty(message = "First name is required")
    private String firstName;
      
    @NotEmpty(message = "Last name is required")
    private String lastName;
      
    @NotEmpty(message = "Email is required")
    @Email
    private String email;
     
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
             message="Mobile number is invalid")
    private String mobilePhone;
     
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
     
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getMobilePhone() {
        return mobilePhone;
    }
 
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
 
    public LocalDate getBirthday() {
        return birthday;
    }
 
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
 

     
}
