package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Students;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long>
{
    Optional<Students> getByStudentId(Long studentId);
    
    Students findByStudentId(Long studentId);

}
