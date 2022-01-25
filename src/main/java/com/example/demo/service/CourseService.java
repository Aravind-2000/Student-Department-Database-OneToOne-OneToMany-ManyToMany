package com.example.demo.service;


import com.example.demo.DTO.CourseDTO;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Students;
import com.example.demo.errorTable.ErrorService;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService
{
    @Autowired
    private CoursesRepository courserepo;

    @Autowired
    private StudentRepository studrepo;

    @Autowired
    private ErrorService errorService;

    public List<CourseDTO> getCourses()
    {
        List<CourseDTO> courseDtos = new ArrayList<>();
        List<Courses> courses = courserepo.findAll();
        courses.forEach(course -> {
            CourseDTO courseDto = mapEntityToDto(course);
            courseDtos.add(courseDto);
        });
        return courseDtos;
    }

    private CourseDTO mapEntityToDto(Courses course) {
        CourseDTO responseDto = new CourseDTO();
        responseDto.setCourseName(course.getCourseName());
        responseDto.setCourseId(course.getCourseId());
        responseDto.setCourseFee(course.getCourseFee());
        responseDto.setMonths(course.getMonths());
        responseDto.setEnrolledStudents(course.getEnrolledStudents().stream().map(Students::getStudentName).collect(Collectors.toList()));
        return responseDto;
    }

    public String addCourse( Courses courses)
    {
        courserepo.save(courses);
        return "Course Added";
    }
    
    public Optional<Courses> getCourseById(Long courseId){
    	return courserepo.findById(courseId);
    }
    
    public String addStudentToCourse(Long studentId, Long courseId) {
        if(courserepo.findById(courseId).isPresent()){
            if(studrepo.findById(studentId).isPresent()){
                Courses course = courserepo.getById(courseId);
                Students student = studrepo.getById(studentId);
                if(!course.enrolledStudents.contains(student)) {
                    course.enrollStudent(student);
                    courserepo.save(course);
                    return "Course Added to student";
                }
                else{
                    return errorService.errorFound(401);
                }
            }
        }
        return errorService.errorFound(410);
    }

    public String deleteStudentFromCourse(Long studentId, Long courseId){
        Courses course = courserepo.getById(courseId);
        Students student = studrepo.getById(studentId);
        course.deleteStudent(student);
        courserepo.save(course);
        return "Course removed";
    }
}
