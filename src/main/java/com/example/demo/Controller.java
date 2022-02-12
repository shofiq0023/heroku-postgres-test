package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class Controller {
    @Autowired
    private StudentService service;

    @GetMapping("/get/all")
    public List<StudentTest> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<StudentTest> getStudent(@PathVariable("id") Long id) {
        return service.getStudent(id);
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody StudentTest student) {
        service.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public StudentTest updateStudent(@PathVariable("id") Long id, @RequestBody StudentTest student) {
       return service.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        service.deleteStudent(id);
    }
}
