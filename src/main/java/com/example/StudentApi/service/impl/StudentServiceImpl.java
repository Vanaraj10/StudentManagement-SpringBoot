package com.example.StudentApi.service.impl;

import com.example.StudentApi.model.Student;
import com.example.StudentApi.repository.StudentRepository;
import com.example.StudentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repo;

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
    @Override
    public Student getStudentByRollNo(String rollNo){
        return repo.findById(rollNo).orElse(null);
    }
    @Override
    public Student addStudent(Student student){
        if(repo.existsById(student.getRollNo())) {
            throw new RuntimeException("Roll No already exists !");
        }
        if(repo.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already exists !");
        }
        return repo.save(student);
    }
    @Override
    public Student updateStudent(String rollNo,Student student){
        Student existingStudent = repo.findById(rollNo).orElse(null);
        if(existingStudent == null) {
            throw new RuntimeException("Student with Roll No " + rollNo + " does not exist.");
        }
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setEmail(student.getEmail());

        return repo.save(existingStudent);
    }
    @Override
    public void deleteStudent(String rollNo){
        repo.deleteById(rollNo);
    }

    @Override
    public Map<String,Object> getAnalytics(){
        List<Student> students = repo.findAll();

        int totalStudents = students.size();
        double averageAge = totalStudents > 0
                ? students.stream().mapToInt(Student::getAge).average().orElse(0.0):0.0;

        Map<String, Object> analytics = new HashMap<>();
        analytics.put("totalStudents", totalStudents);
        analytics.put("averageAge", averageAge);
        return analytics;
    }
}
