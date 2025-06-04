package com.example.StudentApi.controller;

import com.example.StudentApi.model.Student;
import com.example.StudentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // Define endpoints for CRUD operations here

    @GetMapping
    public List<Student> getAll(){
        return service.getAllStudents();
    }
    @GetMapping("/{rollNo}")
    public Student getbyId(@PathVariable String rollNo){
        return service.getStudentByRollNo(rollNo);
    }
    @PostMapping
    public Student create(@RequestBody Student student){
        return service.addStudent(student);
    }
    @PutMapping("/{rollNo}")
    public Student update(@PathVariable String rollNo,@RequestBody Student student){
        return service.updateStudent(rollNo,student);
    }
    @DeleteMapping("/{rollNo}")
    public String delete(@PathVariable String rollNo){
        service.deleteStudent(rollNo);
        return "Deleted Successfully";
    }
    @GetMapping("/analytics")
    public Map<String, Object> getAnalytics() {
        return service.getAnalytics();
    }
}
