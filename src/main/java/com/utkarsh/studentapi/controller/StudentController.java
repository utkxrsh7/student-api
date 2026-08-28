package com.utkarsh.studentapi.controller;

import com.utkarsh.studentapi.model.Student;
import com.utkarsh.studentapi.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}