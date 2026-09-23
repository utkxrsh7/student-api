package com.utkarsh.studentapi.service;

import com.utkarsh.studentapi.dto.StudentDTO;
import com.utkarsh.studentapi.exception.StudentNotFoundException;
import com.utkarsh.studentapi.model.Student;
import org.springframework.stereotype.Service;
import com.utkarsh.studentapi.exception.StudentNotFoundException;

import java.util.ArrayList;

@Service
public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student addStudent(Student student){
        students.add(student);
        return student;
    }

    public Student updateStudent(int id,Student updatedStudent){
        for(Student student:students){
            if(student.getId()==id){
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setEmail(updatedStudent.getEmail());

                return student;
            }
        }

        throw new StudentNotFoundException("Student not found with id: " + id);
    }

    public String deleteStudent(int id){
        for(Student student:students){
            if(student.getId()==id){
                students.remove(student);
                return "Student deleted successfully";
            }
        }

        throw new StudentNotFoundException("Student not found with id: " + id);
    }

    public ArrayList<Student> searchStudent(String name){
        ArrayList<Student> result = new ArrayList<>();

        for(Student student:students){
            if(student.getName().equalsIgnoreCase(name)){
                result.add(student);
            }
        }

        return result;
    }

    // Convert Student model to StudentDTO for API response
    public StudentDTO convertToDTO(Student student){

        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }

    public Student convertToStudent(StudentDTO studentDTO){
        return new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAge(),
                studentDTO.getEmail()
        );
    }
}
