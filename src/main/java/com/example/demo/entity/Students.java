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


    @ManyToMany(mappedBy = "enrolledStudents")
	private Set<Courses> courses ;

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
