package com.example.demo.service;


import com.example.demo.entity.Courses;
import com.example.demo.entity.Students;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService
{
    @Autowired
    private CoursesRepository courserepo;

    @Autowired
    private StudentRepository studrepo;

    public List<Courses> getCourses()
    {
        return courserepo.findAll();
    }

    public String addCourse( Courses courses)
    {
        courserepo.save(courses);
        return "Course Added";
    }
    
    public Optional<Courses> getCourseById(Long courseId){
    	return courserepo.findById(courseId);
    }
    
    public void addStudentToCourse(Long studentId, Long courseId) {
        Courses course = courserepo.getById(courseId);
        Students student = studrepo.getById(studentId);
        if(student != course.enrolledStudents) {
            course.enrollStudent(student);
            courserepo.save(course);
        }
    }
    public String deleteStudentFromCourse(Long studentId, Long courseId){
        Courses course = courserepo.getById(courseId);
        Students student = studrepo.getById(studentId);
        course.deleteStudent(student);
        courserepo.save(course);
        return "Student removed From the course";
    }
}
