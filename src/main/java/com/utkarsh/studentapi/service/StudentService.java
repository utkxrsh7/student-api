package com.utkarsh.studentapi.service;

import com.utkarsh.studentapi.model.Student;
import org.springframework.stereotype.Service;

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

        return null;
    }

    public String deleteStudent(int id){
        for(Student student:students){
            if(student.getId()==id){
                students.remove(student);
                return "Student deleted successfully";
            }
        }

        return "Student not found";
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
}
