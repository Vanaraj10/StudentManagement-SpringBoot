package com.example.StudentApi.service;

import com.example.StudentApi.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentByRollNo(String rollNo);
    Student addStudent(Student student);
    Student updateStudent(String rollNo, Student student);
    void deleteStudent(String rollNo);
}
