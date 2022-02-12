package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<StudentTest, Long> {
}
