package com.example.student_management.service;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.student_management.config.ModelMapperConfig;
import com.example.student_management.dto.AddStudentrequest;
import com.example.student_management.dto.StudentDto;
import com.example.student_management.entities.Student;
import com.example.student_management.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapperConfig;

    public ResponseEntity<List<StudentDto>> getallstudents() {
        List<Student> students = studentRepository.findAll();

        List<StudentDto> studentdto = students.stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
        return ResponseEntity.ok(studentdto);

    }

    public StudentDto getstduentbyid(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id not found"));
        return modelMapperConfig.map(student, StudentDto.class);
    }

    public StudentDto createnewstudent(AddStudentrequest addStudentrequest) {
        Student newstudent = modelMapperConfig.map(addStudentrequest, Student.class);
        Student student = studentRepository.save(newstudent);
        return modelMapperConfig.map(student, StudentDto.class);

    }

    public void deleteid(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student of " + id + " doesnt exist .");
        }
        studentRepository.deleteById(id);
    }

    public StudentDto updateStudentById(Long id, AddStudentrequest addStudentrequest) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cant find the id "));
        modelMapperConfig.map(addStudentrequest, student);
        student = studentRepository.save(student);
        return modelMapperConfig.map(student, StudentDto.class);

    }

    public StudentDto patchupdate(Long id,Map<String,Object> updates) {
     Student student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Id not found"));
     updates.forEach((field,value)->{
        switch (field) {
            case "name":
                student.setName((String)value);
                break;
            case "email":
                student.setEmail((String)value);
            default:
                throw new IllegalArgumentException("Such a field is not present");
              
        }
     });
     Student student1=studentRepository.save(student);
     return modelMapperConfig.map(student1,StudentDto.class);
    }

}
