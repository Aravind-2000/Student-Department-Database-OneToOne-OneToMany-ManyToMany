package com.example.demo.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Students 
{
	@Id
	private Long studentId;
	
	private String studentName;

	private Long departmentId;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Students_Courses", joinColumns = {
			@JoinColumn(name = "Student_ID")},
			inverseJoinColumns = {@JoinColumn(name = "Course_ID")})
	Set<Courses> courses = new HashSet<>();

	//Getters and Setters
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


}
