package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.*;
import com.example.demo.entity.*;

@RestController
public class MainController 
{
	@Autowired
	private StudentService studservice;
	
	@Autowired
	private DepartmentService deptservice;
	
	
	//Student Controller
	@GetMapping("/students/getall")
	public List<Students> getStud()
	{
		return studservice.getStudents();
	}
	@PostMapping("students/add")
	public String addStud(@RequestBody Students students)
	{
		return studservice.addStudents(students);
	}
	@GetMapping("students/get/{id}")
	public Optional<Students> getbyStudId(@PathVariable("id") Long id)
	{
		return studservice.getStudentById(id);
	}
	
	
	
	
	//Department Controller
	@GetMapping("/departments/getall")
	public List<Departments> getDept()
	{
		return deptservice.getDepartments();
	}
	
	@PostMapping("departments/add")
	public String addDept(@RequestBody Departments departments)
	{
		return deptservice.addDepartment(departments);
	}
	@GetMapping("departments/get/{id}")
	public Optional<Departments> getbyDeptId(@PathVariable("id") Long id)
	{
		return deptservice.getDepartmentById(id);
	}

}
