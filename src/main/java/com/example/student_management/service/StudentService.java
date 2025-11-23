package com.example.student_management.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.student_management.config.ModelMapperConfig;
import com.example.student_management.dto.StudentDto;
import com.example.student_management.entities.Student;
import com.example.student_management.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapperConfig;

    public ResponseEntity<List<StudentDto>> getallstudents(){
         List<Student> students = studentRepository.findAll();

        List<StudentDto> studentdto=students.stream().
        map(student -> new StudentDto(student.getId(),student.getName(), student.getEmail()))
                .toList();
        return ResponseEntity.ok(studentdto);

    }

    
    public StudentDto getstduentbyid(Long id){
        Student student= studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id not found"));
        return modelMapperConfig.map(student,StudentDto.class);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createstudent(){
        

    }

}
