package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.Student_profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentsProfileRepository extends JpaRepository<Student_profile, Long>
{

}
