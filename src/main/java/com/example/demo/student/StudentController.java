package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private  final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentBean> hello(){
        return studentService.getStudentList();
    }

    @PostMapping
    public void addNewStudent(@RequestBody StudentBean studentBean) throws IllegalStateException {
        studentService.addNewStudent(studentBean);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") int id){
        System.out.println("Deleting student with id "+ id);
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") int studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false)  String email){
        System.out.println("controller for update");
        studentService.updateStudent(studentId, name, email);
    }
}
