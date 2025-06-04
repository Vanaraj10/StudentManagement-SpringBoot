package com.example.StudentApi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="students")
public class Student {
    @Id
    private String rollNo;
    private String name;
    private int age;
    private String department;
    private String email;

    public Student() {
    }
    public Student(String rollNo, String name, int age, String department, String email) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.department = department;
        this.email = email;
    }
    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
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
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
