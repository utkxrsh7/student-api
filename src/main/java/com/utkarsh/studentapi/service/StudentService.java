package com.utkarsh.studentapi.service;

import com.utkarsh.studentapi.dto.StudentDTO;
import com.utkarsh.studentapi.exception.StudentNotFoundException;
import com.utkarsh.studentapi.model.Student;
import org.springframework.stereotype.Service;
import com.utkarsh.studentapi.exception.StudentNotFoundException;
import java.util.Comparator;

import java.util.ArrayList;

@Service
public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public StudentDTO getStudentById(int id){
        for(Student student:students){
            if(student.getId()==id){
                return convertToDTO(student);
            }
        }

        throw new StudentNotFoundException("Student not found with id: "+id);
    }

    public StudentDTO addStudent(StudentDTO studentDTO){
        Student student = convertToStudent(studentDTO);
        students.add(student);
        return convertToDTO(student);
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
            if(student.getName().toLowerCase().contains(name.toLowerCase())){
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

    public ArrayList<Student> searchByAge(int age){
        ArrayList<Student> result = new ArrayList<>();

        for(Student student:students){
            if(student.getAge()==age){
                result.add(student);
            }
        }

        return result;
    }

    public Student findByEmail(String email){
        for(Student student:students){
            if(student.getEmail().equalsIgnoreCase(email)){
                return student;
            }
        }

        throw new StudentNotFoundException("Student not found");
    }

    public int getStudentCount(){
        return students.size();
    }

    public ArrayList<Student> getStudentsByAgeRange(int min,int max){
        ArrayList<Student> result = new ArrayList<>();

        for(Student student:students){
            if(student.getAge() >= min && student.getAge() <= max){
                result.add(student);
            }
        }

        return result;
    }

    public ArrayList<Student> sortStudentsByAge(){
        ArrayList<Student> result = new ArrayList<>(students);
        result.sort(Comparator.comparingInt(Student::getAge));
        return result;
    }
}
