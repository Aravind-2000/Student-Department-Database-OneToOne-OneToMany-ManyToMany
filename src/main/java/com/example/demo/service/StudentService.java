package com.example.demo.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;

import com.example.demo.repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	private StudentRepository studrepo;
	
	public List<Students> getStudents()
	{
		return studrepo.findAll();
	}
	
	public String addStudents(Students students)
	{
		studrepo.save(students);
		return "Student added";
	}
	
	public Optional<Students> getStudentById(Long id)
	{
		return studrepo.findById(id);
	}

}
