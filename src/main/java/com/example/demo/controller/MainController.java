package com.example.demo.controller;

import java.util.*;

import com.example.demo.DTO.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.*;
import com.example.demo.entity.*;


@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class MainController 
{
	@Autowired
	private StudentService studservice;
	
	@Autowired
	private DepartmentService deptservice;

	@Autowired
	private CourseService courseService;

	@Autowired
	private BankService bankService;
	
	
	//Student Controller
	@GetMapping("/students/getall")
	public List<Students> getStud()
	{
		return studservice.getStudents();
	}
	@GetMapping("students/get/{id}")
	public Optional<Students> getbyStudId(@PathVariable("id") Long studentId)
	{
		return studservice.getStudentById(studentId);
	}
	@PostMapping(path = "students/add")
	public String addStud(@RequestBody Students students)
	{
		return studservice.addStudents(students);
	}

	@PatchMapping("students/update/{id}")
	public String updateStud(@PathVariable("id") Long studentId, @RequestBody Students students)
	{
		return studservice.updateStudents(studentId,students);
	}

	@DeleteMapping("students/delete/{id}")
	public String deleteStud(@PathVariable("id") Long studentId){return studservice.deleteStudents(studentId);}
	//Student Profile Controller
	@PostMapping("studentprofile/add")
	public String addStudentProfile( @RequestBody Student_profile student_profile)
	{
		return studservice.addStudentsProfile(student_profile);
	}

	@GetMapping("studentprofile/getall")
	public List<Student_profile> getStudProf()
	{
		return studservice.getStudentProfile();
	}

	@GetMapping("studentprofile/get/{id}")
	public Optional<Student_profile> getStudProfByStudId(@PathVariable("id") Long studentId)
	{
		return studservice.getStudProfByStudId(studentId);
	}

	@PatchMapping("studentprofile/update/{id}")
	public String updateStudProf(@PathVariable("id") Long id, @RequestBody Student_profile student_profile)
	{
		return studservice.updateSTudProf(id, student_profile);
	}

	@DeleteMapping("studentprofile/delete/{id}")
	public String deleteStudProfByID(@PathVariable("id") Long studentId)
	{
		return studservice.deleteStudProfById(studentId);
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


	//Courses
	@GetMapping("courses/getall")
	public List<CourseDTO> getCourse()
	{
		return courseService.getCourses();
	}

	@PostMapping("courses/add")
	public String addCourse(@RequestBody Courses course)
	{
		return courseService.addCourse(course);
	}

	@GetMapping("courses/get/{id}")
	public Optional<Courses> getCourseById(@PathVariable("id") Long courseId){
		return courseService.getCourseById(courseId);
	}
	@PutMapping("/students/{studentId}/{courseIdArr}")
	public String enrollcoursetostudent(@PathVariable Long studentId, @PathVariable Long courseIdArr){
		return courseService.addStudentToCourse(studentId, courseIdArr);
	}

	@DeleteMapping("/students/{studentId}/{courseId}")
	public String deletecoursefromstudent(@PathVariable Long studentId, @PathVariable Long courseId){
		 return courseService.deleteStudentFromCourse(studentId, courseId);
	}


	//Bank Controller ##########
	@GetMapping("bankaccount/getall")
	public List<BankAccount> getAllAccounts(){
		return bankService.getAllAccounts();
	}

	@PostMapping("bankaccount/add")
	public String addAccount(@RequestBody BankAccount account){
		return bankService.addAccount(account);
	}

	@GetMapping("bankaccount/getall/{bankId}")
	public Optional<BankAccount> getAccountById(@PathVariable Long bankId){
		return bankService.getAccountById(bankId);
	}
}
