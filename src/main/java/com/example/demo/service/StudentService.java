package com.example.demo.service;

import java.util.*;

import com.example.demo.errorTable.ErrorService;
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

	@Autowired
	private ErrorService errorService;
	
	public List<Students> getStudents()
	{
		return studrepo.findAll();
	}
	
	public String addStudents(Students students)
	{
		studrepo.save(students);
		return "Student " + students.getStudentName() + " with ID " + students.getStudentId() + " added";
	}
	
	public Students getStudentById(Long studentId)
	{
		 return studrepo.findById(studentId).get();
	}
	
	
	public String updateStudents(Long studentId , Students students )
	{
		Students stud = studrepo.findByStudentId(studentId);
		
		if(students.getStudentId() != null)
		{
			stud.setStudentId(students.getStudentId());
		}
		if(students.getStudentName() != null){
			stud.setStudentName(students.getStudentName());
		}
		if(students.getDepartmentId() != null)
		{
			stud.setDepartmentId(students.getDepartmentId());
		}
		studrepo.save(stud);
		return "Student ID " + studentId + " details updated successfully";
	}

	public String deleteStudents(Long studentId)
	{
		if(studrepo.findById(studentId).isPresent()){
			studrepo.deleteById(studentId);
			return "Student ID " + studentId + " details deleted successfully";
		}
		else{
			return  errorService.errorFound(410);
		}
	}
	//Student Profile
	public String addStudentsProfile(Student_profile studprof)
	{
		studprofrepo.save(studprof);
		return "Student Profile Added Succesfully";
	}
	public List<Student_profile>  getStudentProfile()
	{
		return studprofrepo.findAll();
	}
	public Optional<Student_profile> getStudProfByStudId(Long studentId)
	{
		return studprofrepo.findById(studentId);
	}

	public String updateSTudProf(Long id, Student_profile sp)
	{
		Student_profile studprof = studprofrepo.getById(id);
		if(sp.getAddressLine1() != null)
		{
			studprof.setAddressLine1(sp.getAddressLine1());
		}
		if(sp.getAddressLine2() != null)
		{
			studprof.setAddressLine2(sp.getAddressLine2());
		}
		if(sp.getCity() != null)
		{
			studprof.setCity(sp.getCity());
		}
		if(sp.getGender() != null)
		{
			studprof.setGender(sp.getGender());
		}
		if(sp.getCountry() != null)
		{
			studprof.setCountry(sp.getCountry());
		}
		if(sp.getState() != null)
		{
			studprof.setState(sp.getState());
		}
		if(sp.getPincode() != null)
		{
			studprof.setPincode(sp.getPincode());
		}
		if(sp.getPhoneNumber() != null)
		{
			studprof.setPhoneNumber(sp.getPhoneNumber());
		}
		if(sp.getBankAccount() != null)
		{
			studprof.setBankAccount(sp.getBankAccount());
		}
		studprofrepo.save(studprof);
		return "Student Profile Updated Successfully";
	}

	public String deleteStudProfById(Long id)
	{
		if(studprofrepo.findById(id).isPresent()){
			studprofrepo.deleteById(id);
			return "Student Profile deleted Successfully";
		}
			return errorService.errorFound(410);
	}
}
