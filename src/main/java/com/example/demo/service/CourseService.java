package com.example.demo.service;


import com.example.demo.entity.Courses;
import com.example.demo.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Access;
import java.util.List;

@Service
public class CourseService
{
    @Autowired
    private CoursesRepository courserepo;

    public List<Courses> getCourses()
    {
        return courserepo.findAll();
    }

    public String addCourse( Courses courses)
    {
        courserepo.save(courses);
        return "Course Added";
    }
}
