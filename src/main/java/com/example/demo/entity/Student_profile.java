package com.example.demo.entity;


import com.example.demo.component.bankComponent;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;

@Entity
public class Student_profile
{

	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 @PrimaryKeyJoinColumn
	 @JoinColumn(name = "student_Id", referencedColumnName = "studentId", nullable = false)
	 private Students students;


	@Id
	private long id;
	 
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String addressLine1;
    private String addressLine2;

    private String city;
    private String state;
    private String pincode;
    private String country;

    private Long bankId;
    @OneToOne
    @JoinColumn(name = "bankId", updatable = false, insertable = false)
    private BankAccount bankAccount;



    //Getter and Setters
    
    public Students getStudents() {
		return students;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

    public String getPhoneNumber() {
        return phoneNumber;
    }

	public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
