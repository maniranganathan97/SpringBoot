package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRespository extends JpaRepository<StudentBean, Integer> {

    @Query("select s from StudentBean s where s.email=?1")
    Optional<StudentBean> findByMail(String mail);
}
