package com.example.demo.service;


import com.example.demo.entity.Courses;
import com.example.demo.entity.Students;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Access;
import java.util.List;

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
    public String addStudentToCourse(Long courseId, Long studentId) {
        Courses course = courserepo.getById(courseId);
        Students student = studrepo.getById(studentId);
        course.enrollStudent(student);
        courserepo.save(course);
        return "Student Added to the course";
    }
    public String deleteStudentFromCourse(Long courseId, Long studentId){
        Courses course = courserepo.getById(courseId);
        Students student = studrepo.getById(studentId);
        course.deleteStudent(student);
        courserepo.save(course);
        return "Student removed From the course";
    }
}
