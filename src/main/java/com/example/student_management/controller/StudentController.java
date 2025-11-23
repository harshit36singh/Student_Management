package com.example.student_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.dto.AddStudentrequest;
import com.example.student_management.dto.StudentDto;
import com.example.student_management.entities.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> studentcontroller() {
        return studentService.getallstudents();
    }

    @GetMapping("/{id}")
    public StudentDto getstudentbyid(@PathVariable("id") Long studentid) {
        return studentService.getstduentbyid(studentid);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createstudent(@RequestBody AddStudentrequest addStudentrequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createnewstudent(addStudentrequest));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteid(@PathVariable Long id) {
        studentService.deleteid(id);
        return ResponseEntity.noContent().build(); }
    @PutMapping("update/{id}")
    public ResponseEntity<StudentDto> updatestudentbyid(@PathVariable Long id,
            @RequestBody AddStudentrequest addStudentrequest) {
        return ResponseEntity.ok(studentService.updateStudentById(id, addStudentrequest));
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<StudentDto> updatestudent(@PathVariable Long id,
            @RequestBody Map<String,Object>  updates) {
                return ResponseEntity.ok(studentService.patchupdate(id,updates));
    }
}
