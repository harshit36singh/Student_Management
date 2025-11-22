package com.example.student_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.dto.StudentDto;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto studentcontroller() {
        return new StudentDto("Ram", 54);
    }

}
