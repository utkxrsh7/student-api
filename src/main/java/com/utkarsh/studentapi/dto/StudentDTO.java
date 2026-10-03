package com.utkarsh.studentapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;

public class StudentDTO {
    @Positive
    @Max(9999)
    private int id;
    @NotBlank
    @Size(min=2,max=30)
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters")
    private String name;
    @Min(18)
    @Max(100)
    private int age;
    @Size(max=100)
    @NotBlank
    @Email
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$",
            message = "Email must end with .com"
    )
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
