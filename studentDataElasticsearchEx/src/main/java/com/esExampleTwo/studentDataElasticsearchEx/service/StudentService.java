package com.esExampleTwo.studentDataElasticsearchEx.service;

import com.esExampleTwo.studentDataElasticsearchEx.model.Student;
import com.esExampleTwo.studentDataElasticsearchEx.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void save(final Student student) {
        studentRepository.save(student);
    }

    public Student findById(final String id) {
        return studentRepository.findById(id).orElse(null);
    }

}
