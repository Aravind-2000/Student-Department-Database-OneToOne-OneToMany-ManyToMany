package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.Student_profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentsProfileRepository extends JpaRepository<Student_profile, Long>
{
    @Query("select sp  from Student_profile sp where sp.students.studentId = ?1")
    List<Student_profile> getSTudProfByStudId(Long studentId);
}
