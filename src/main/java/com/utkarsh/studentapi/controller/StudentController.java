package com.utkarsh.studentapi.controller;

import com.utkarsh.studentapi.dto.StudentDTO;
import com.utkarsh.studentapi.model.Student;
import com.utkarsh.studentapi.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

import java.util.ArrayList;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ArrayList<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id){
        StudentDTO student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO){
        StudentDTO newStudent = studentService.addStudent(studentDTO);
        return ResponseEntity.status(201).body(newStudent);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        String result = studentService.deleteStudent(id);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ArrayList<Student> searchStudent(@RequestParam String name){
        return studentService.searchStudent(name);
    }

    @GetMapping("/search/age")
    public ArrayList<Student> searchByAge(@RequestParam int age){
        return studentService.searchByAge(age);
    }

    @GetMapping("/search/email")
    public Student findByEmail(@RequestParam String email){
        return studentService.findByEmail(email);
    }

    @GetMapping("/count")
    public int getStudentCount(){
        return studentService.getStudentCount();
    }

    @GetMapping("/search/age-range")
    public ArrayList<Student> getStudentsByAgeRange(@RequestParam("min") int min,@RequestParam("max") int max){
        return studentService.getStudentsByAgeRange(min, max);
    }
}