package com.example.StudentApi.repository;

import com.example.StudentApi.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {
    // Additional query methods can be defined here if needed
    boolean existsByEmail(String email);
}
