package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.ClassYearRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassYearRepository classYearRepository;

    @PostMapping("/student")
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/students/{classYearId}")
    public List<Student> getAllStudentsByClassYearId(@PathVariable int classYearId) {
        return studentService.getAllStudentsByClassYearId(classYearId);
    }

    @PutMapping("/student/{studentId}/classYear/{classYearId}")
    public Student addClassYearToStudent(@PathVariable int studentId, @PathVariable int classYearId) {
        return studentService.addClassYearToStudent(studentId, classYearId);
    }

    @GetMapping("/student/{studentUsername}/{studentPassword}")
    public Student getStudentByStudentUsernameAndStudentPassword(@PathVariable String studentUsername, @PathVariable String studentPassword) {
        return studentService.getStudentByStudentUsernameAndStudentPassword(studentUsername, studentPassword);
    }
}
