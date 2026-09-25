package com.utkarsh.studentapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;

public class StudentDTO {
    @Positive
    private int id;
    @NotBlank
    private String name;
    @Min(1)
    private int age;
    @Email
    private String email;

    public StudentDTO(){

    }
    public StudentDTO(int id,String name,int age,String email){
        this.id=id;
        this.name=name;
        this.age=age;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
