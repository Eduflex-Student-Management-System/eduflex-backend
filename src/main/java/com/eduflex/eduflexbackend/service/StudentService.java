package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.ClassYear;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.StudentLeave;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student updateStudent(Student student);
    List<Student> getAllStudents();
    void deleteStudent(int studentId);
    Student getStudentById(int studentId);
    List<Student> getAllStudentsByClassYearId(int classYearId);
    Student addClassYearToStudent(int studentId, int classYearId);
}
