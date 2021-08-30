package com.example.demo.student;

import javax.persistence.*;

@Entity
@Table
public class StudentBean {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    public int id;
    public String name;
    public String email;


    public StudentBean(){

    }

    public StudentBean(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public StudentBean(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
