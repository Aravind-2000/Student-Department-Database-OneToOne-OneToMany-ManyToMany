package com.example.demo.service;

import java.util.*;

import com.example.demo.repository.StudentsProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;

import com.example.demo.repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	private StudentRepository studrepo;
	@Autowired
	private StudentsProfileRepository studprofrepo;
	
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
	public String updateStudents(Long studentId , Students students )
	{
		Students stud = studrepo.getById(studentId);
		if(students.getStudentName() != null){
			stud.setStudentName(students.getStudentName());
		}
		if(students.getDepartmentId() != null)
		{
			stud.setDepartmentId(students.getDepartmentId());
		}
		studrepo.save(stud);
		return "Student Details updated successfully";
	}

	public String deleteStudents(Long studentId)
	{
		studrepo.deleteById(studentId);
		return "Student details deleted successfully";
	}
	//Student Profile
	public String addStudentsProfile(Student_profile studprof)
	{
		studprofrepo.save(studprof);
		return "Student Profile Updated";
	}
	public List<Student_profile>  getStudentProfile()
	{
		return studprofrepo.findAll();
	}
	public List<Student_profile> getStudProfByStudId(Long studentId)
	{
		return studprofrepo.getSTudProfByStudId(studentId);
	}

}
