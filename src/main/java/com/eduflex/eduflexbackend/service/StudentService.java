package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.Subject;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student updateStudent(Student student);
    List<Student> getAllStudents();
    void deleteStudent(int studentId);
    Student getStudentById(int studentId);
}
