package com.eduflex.eduflexbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.repository.ClassYearRepository;
import com.eduflex.eduflexbackend.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;
    
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    ClassYearRepository classYearRepository;

    @PostMapping("/student")
    public Student addStudent(@Valid @RequestBody Student student) {
    	if(StringUtils.isBlank(student.getStudentName())) {
    		throw new EduflexDataNotFoundException("Student Name is required");
    	}
        return studentService.addStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
    	if(studentRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Student Not Found, Add student first");
		}
        return studentService.getAllStudents();
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
    	if(!studentRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("Can't delete student, studentId: "+studentId+" not persent in database");
    	}
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
    	if(!studentRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("Can't find student with studentId: "+studentId+", please insert first");
    	}
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/students/{classYearId}")
    public List<Student> getAllStudentsByClassYearId(@PathVariable int classYearId){
    	if(studentRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Student with classYearId "+classYearId+" Not Found, Add student first");
		}
        return studentService.getAllStudentsByClassYearId(classYearId);
    }

    @PutMapping("/student/{studentId}/classYear/{classYearId}")
    public Student addClassYearToStudent(@PathVariable int studentId, @PathVariable int classYearId){
    	if(!studentRepository.existsById(studentId) && !classYearRepository.existsById(classYearId)) {
    		throw new EduflexDataNotFoundException("classYearId  "+classYearId+" can't be inserted to studentId "+studentId);
    	}
        return studentService.addClassYearToStudent(studentId,classYearId);
    }
}
