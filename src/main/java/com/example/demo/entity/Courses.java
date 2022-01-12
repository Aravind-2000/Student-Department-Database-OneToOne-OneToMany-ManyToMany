package com.example.demo.entity;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
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
    @JoinTable(
            name = "Enrolled_Students",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Students> enrolledStudents = new HashSet<>();

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

    public Set<Students> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Students> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void enrollStudent(Students students){
        enrolledStudents.add(students);
    }
    public void deleteStudent(Students students){
        enrolledStudents.remove(students);
    }
}
