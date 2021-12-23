package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Students 
{
	@Id
	private Long studentId;
	
	private String studentName;

	private Long departmentId;


//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JoinTable(name = "Students_Courses", joinColumns = {
//			@JoinColumn(name = "Student_ID", referencedColumnName = "studentId", nullable = false, updatable = false)},
//			inverseJoinColumns = {@JoinColumn(name = "Course_ID", referencedColumnName = "courseId",  nullable = false, updatable = false)})
//	Set<Courses> courses = new HashSet<>();

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
