package com.example.demo.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.*;
import com.example.demo.repository.DepartmentsRepository;

@Service
public class DepartmentService 
{
	@Autowired
	private DepartmentsRepository deptrepo;
	
	public List<Departments> getDepartments()
	{
		return deptrepo.findAll();
	}
	
	public String addDepartment(Departments departments)
	{
		deptrepo.save(departments);
		return "Department added";
	}
	
	public Optional<Departments> getDepartmentById(Long id)
	{
		return deptrepo.findById(id);
	}

}
