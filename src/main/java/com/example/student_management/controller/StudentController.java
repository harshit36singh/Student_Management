package com.example.student_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.dto.StudentDto;
import com.example.student_management.entities.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> studentcontroller() {
        return studentService.getallstudents();
    }

    @GetMapping("/{id}")
    public StudentDto getstudentbyid(@PathVariable("id") Long studentid){
        return studentService.getstduentbyid(studentid);
    }



}
