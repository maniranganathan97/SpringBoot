package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRespository respository){
        return args -> {
            StudentBean mani = new StudentBean("mani", "mani@gmail.com");
            StudentBean hari = new StudentBean("hari", "hari@gmail.com");
            List<StudentBean> list = new ArrayList<>();
            list.add(mani);
            list.add(hari);
            respository.saveAll(list);
        };
    }
}
