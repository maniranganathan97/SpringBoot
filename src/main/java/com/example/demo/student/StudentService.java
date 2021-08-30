package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    public StudentRespository studentRespository;

    @Autowired
    public StudentService(StudentRespository studentRespository){
        this.studentRespository = studentRespository;
    }

    public List<StudentBean> getStudentList(){

       /* StudentBean bean = new StudentBean(1, "Mani", "manimail.com");
        List<StudentBean> studentBeanList = new ArrayList<>();
        studentBeanList.add(bean);
        return studentBeanList;*/

        return studentRespository.findAll();
    }

    public void addNewStudent(StudentBean studentBean) throws IllegalStateException {
        System.out.println(
                "Saving new student bean to the database"
        );
        System.out.println(studentBean.getName());

        Optional<StudentBean> optional = studentRespository.findByMail(studentBean.getEmail());
        if(optional.isPresent()){
            throw new IllegalStateException("Email is already taken");
        }
        studentRespository.save(studentBean);

    }

    public void deleteStudentById(int studentId) {

        boolean isExists = studentRespository.existsById(studentId);
        if(!isExists){
            throw  new IllegalStateException("Cannot find student with id "+ studentId);
        }
        studentRespository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(int studentId, String name, String email) {
        boolean isExists = studentRespository.existsById(studentId);
        StudentBean studentBean = studentRespository.getById(studentId);
        if(!isExists){
            throw  new IllegalStateException("Cannot find student with id "+ studentId);
        }
        if(name != null && name.length() > 0 && !Objects.equals(studentBean.getName(), name)){
            System.out.println("you are trying to update name here");
            studentBean.setName(name);
            System.out.println("Name has been updated");
        }
        if(email != null && email.length() > 0 && !Objects.equals(studentBean.getEmail(), email)){
            System.out.println(" You are trying to update an email ");
            Optional<StudentBean> optional = studentRespository.findByMail(email);
            if(optional.isPresent()){
                throw new IllegalStateException("Email is already taken");
            }
            studentBean.setEmail(email);
            System.out.println("Email has been updated");
        }
    }

}