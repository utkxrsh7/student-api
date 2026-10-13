package com.utkarsh.studentapi.service;

import com.utkarsh.studentapi.dto.StudentDTO;
import com.utkarsh.studentapi.exception.StudentNotFoundException;
import com.utkarsh.studentapi.model.Student;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Iterator;
import com.utkarsh.studentapi.exception.DuplicateStudentException;

@Service
public class StudentService {

    private final ArrayList<Student> students = new ArrayList<>();

    public ArrayList<StudentDTO> getStudents() {
        return convertList(students);
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
        for(Student existing:students){
            if(existing.getId()==studentDTO.getId()){
                throw new DuplicateStudentException("Student already exists with id: "+ studentDTO.getId());
            }
        }
        Student student = convertToStudent(studentDTO);
        students.add(student);
        return convertToDTO(student);
    }

    public StudentDTO updateStudent(int id,StudentDTO updatedDTO){
        for(Student student:students){
            if(student.getId()==id){
                student.setName(updatedDTO.getName());
                student.setAge(updatedDTO.getAge());
                student.setEmail(updatedDTO.getEmail());

                return convertToDTO(student);
            }
        }

        throw new StudentNotFoundException("Student not found with id: " + id);
    }

    public String deleteStudent(int id){
        Iterator<Student> iterator = students.iterator();

        while(iterator.hasNext()){
            Student student = iterator.next();

            if(student.getId()==id){
                iterator.remove();
                return  "Student deleted successfully";
            }
        }

        throw new StudentNotFoundException("Student not found with id: " + id);
    }

    public ArrayList<StudentDTO> searchStudent(String name){
        ArrayList<Student> result = new ArrayList<>();

        for(Student student:students){
            if(student.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(student);
            }
        }

        return convertList(result);
    }

    public ArrayList<StudentDTO> searchByAge(int age){
        ArrayList<Student> result = new ArrayList<>();

        for(Student student:students){
            if(student.getAge()==age){
                result.add(student);
            }
        }

        return convertList(result);
    }

    public StudentDTO findByEmail(String email){
        for(Student student:students){
            if(student.getEmail().equalsIgnoreCase(email)){
                return convertToDTO(student);
            }
        }

        throw new StudentNotFoundException("Student not found");
    }

    public int getStudentCount(){
        return students.size();
    }

    public ArrayList<StudentDTO> getStudentsByAgeRange(int min,int max){
        if(min > max){
            throw new IllegalArgumentException("Minimum age cannot exceed maximum age");
        }
        ArrayList<Student> result = new ArrayList<>();

        for(Student student:students){
            if(student.getAge() >= min && student.getAge() <= max){
                result.add(student);
            }
        }

        return convertList(result);
    }

    public ArrayList<StudentDTO> sortStudentsByAge(){
        ArrayList<Student> result = new ArrayList<>(students);
        result.sort(Comparator.comparingInt(Student::getAge));
        return convertList(result);
    }

    public ArrayList<StudentDTO> searchByKeyword(String keyword){
        ArrayList<Student> result = new ArrayList<>();

        for(Student student:students){
            if(student.getName().toLowerCase().contains(keyword.toLowerCase())){
                result.add(student);
            }
        }

        return convertList(result);
    }

    public ArrayList<StudentDTO> sortStudentsByName(){
        ArrayList<Student> result = new ArrayList<>(students);
        result.sort(Comparator.comparing(Student::getName,String.CASE_INSENSITIVE_ORDER));

        return convertList(result);
    }

    // Convert one internal model to the API response DTO.
    public StudentDTO convertToDTO(Student student){

        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }

    // Convert incoming request DTO to the internal model.
    public Student convertToStudent(StudentDTO studentDTO){
        return new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAge(),
                studentDTO.getEmail()
        );
    }

    // Convert a list of models into a list of response DTOs.
    private ArrayList<StudentDTO> convertList(ArrayList<Student> source){
        ArrayList<StudentDTO> result = new ArrayList<>();
        for(Student student:source){
            result.add(convertToDTO(student));
        }

        return result;
    }

    // a...
}
