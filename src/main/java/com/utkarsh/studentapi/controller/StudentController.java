package com.utkarsh.studentapi.controller;

import com.utkarsh.studentapi.model.Student;
import com.utkarsh.studentapi.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent = studentService.addStudent(student);
        return ResponseEntity.status(201).body(newStudent);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        String result = studentService.deleteStudent(id);

        if(result.equals("Student deleted successfully")){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ArrayList<Student> searchStudent(@RequestParam String name){
        return studentService.searchStudent(name);
    }
}