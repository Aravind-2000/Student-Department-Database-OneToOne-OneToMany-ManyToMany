package com.example.demo.entity;



import java.util.*;
import javax.persistence.*;

@Entity
public class Departments
{
	@Id
	private Long deptId;
	private String deptName;

	
	@OneToMany(mappedBy = "departmentId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Students> students = new ArrayList<>();
	

	// Getters and Setters
	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

}
