package com.utkarsh.studentapi.controller;

import com.utkarsh.studentapi.dto.StudentDTO;
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
    public ArrayList<StudentDTO> getStudents(){
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
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int id,@Valid @RequestBody StudentDTO studentDTO){

        StudentDTO updated = studentService.updateStudent(id, studentDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @GetMapping("/search")
    public ArrayList<StudentDTO> searchStudent(@RequestParam String name){
        return studentService.searchStudent(name);
    }

    @GetMapping("/search/age")
    public ArrayList<StudentDTO> searchByAge(@RequestParam int age){
        return studentService.searchByAge(age);
    }

    @GetMapping("/search/email")
    public StudentDTO findByEmail(@RequestParam String email){
        return studentService.findByEmail(email);
    }

    @GetMapping("/count")
    public int getStudentCount(){
        return studentService.getStudentCount();
    }

    @GetMapping("/search/age-range")
    public ArrayList<StudentDTO> getStudentsByAgeRange(@RequestParam("min") int min,@RequestParam("max") int max){
        return studentService.getStudentsByAgeRange(min, max);
    }

    @GetMapping("/sort/age")
    public ArrayList<StudentDTO> sortStudentsByAge(){
        return studentService.sortStudentsByAge();
    }

    @GetMapping("/search/keyword")
    public ArrayList<StudentDTO> searchByKeyword(@RequestParam String keyword){
        return studentService.searchByKeyword(keyword);
    }

    @GetMapping("/sort/name")
    public ArrayList<StudentDTO> sortStudentsByName(){
        return studentService.sortStudentsByName();
    }

}