package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentTest {
    @Id
    private Long id;
    private String name;
    private String blood;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public StudentTest(Long id, String name, String blood) {
        this.id = id;
        this.name = name;
        this.blood = blood;
    }

    public StudentTest(String name, String blood) {
        this.name = name;
        this.blood = blood;
    }

    public StudentTest() {
    }
}
