package com.example.demo.entity;


import javax.persistence.*;
import java.time.Month;
import java.util.*;

@Entity
public class Courses
{
    @Id
    private int courseId;
    private String courseName;
    private int courseFee;
    private int months;

//    @ManyToMany(mappedBy = "courses")
//    List<Students> students = new ArrayList<>();



    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(int courseFee) {
        this.courseFee = courseFee;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }
}
