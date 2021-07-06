package com.esExampleTwo.studentDataElasticsearchEx.controller;

import com.esExampleTwo.studentDataElasticsearchEx.model.Student;
import com.esExampleTwo.studentDataElasticsearchEx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public void saveStudent(@RequestBody final Student student){
        studentService.save(student);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable final String id){
        return studentService.findById(id);
    }
}
