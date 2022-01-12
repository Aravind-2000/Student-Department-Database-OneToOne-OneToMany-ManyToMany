package com.example.demo.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

@Entity
public class Students
{
	@Id
	private Long studentId;
	
	private String studentName;

	private Long departmentId;

	@ManyToMany(mappedBy = "enrolledStudents")
	@JsonIgnore
	private Set<Courses> courses = new HashSet<>();

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "students_courses",
//			joinColumns = {
//					@JoinColumn(name = "student_id", referencedColumnName = "studentId",
//							nullable = false)},
//			inverseJoinColumns = {
//					@JoinColumn(name = "course_id", referencedColumnName = "courseId",
//							nullable = false)})
//	private List<Courses> courses = new ArrayList<>();


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

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

}
