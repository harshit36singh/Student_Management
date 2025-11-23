package com.example.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student_management.dto.AddStudentrequest;
import com.example.student_management.dto.StudentDto;
import com.example.student_management.entities.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

  
    
}
