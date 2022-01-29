package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;

@Entity
public class Courses implements Serializable
{
    @Id
    private Long courseId;

    private String courseName;
    private int courseFee;
    private int months;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "Enrolled_Students",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    public List<Students> enrolledStudents = new ArrayList<>();

    //Getters and Setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
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

    public List<Students> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Students> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void enrollStudent(Students students){
        enrolledStudents.add(students);
    }
    public void deleteStudent(Students students){
        enrolledStudents.remove(students);
    }
}
