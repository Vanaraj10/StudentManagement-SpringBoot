package com.example.StudentApi.service;

import com.example.StudentApi.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentByRollNo(String rollNo);
    Student addStudent(Student student);
    Student updateStudent(String rollNo, Student student);
    void deleteStudent(String rollNo);
    Map<String,Object> getAnalytics(); // New method for analytics
}
