package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepo repo;

    public List<StudentTest> getAll() {
        List<StudentTest> students = new ArrayList<>();
        repo.findAll().forEach(students::add);
        logger.info("[Getting all students from DB]");
        return students;
    }

    @Cacheable(cacheNames = "students", key = "#id")
    public Optional<StudentTest> getStudent(Long id) {
        logger.info("[Getting "+ id +" from DB]");
        return repo.findById(id);
    }

    public void addStudent(StudentTest student) {
        logger.info("[Adding student to DB]");
        repo.save(student);
    }

    @CachePut(cacheNames = "students", key = "#id")
    public StudentTest updateStudent(Long id, StudentTest student) {
        if(repo.existsById(id)) {
            repo.save(student);
            logger.info("[Updating student id " + id + " in DB]");
            return student;
        } else {
            logger.info("[Something went wrong]");
            return null;
        }
    }

    @CacheEvict(cacheNames = "students", key = "#id")
    public void deleteStudent(Long id) {
        logger.info("[Deleting student " + id +" from DB]");
        repo.deleteById(id);
    }
}
