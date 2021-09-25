package com.eduflex.eduflexbackend.service.impl;

import com.eduflex.eduflexbackend.model.ClassYear;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.ClassYearRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.ClassYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassYearServiceImpl implements ClassYearService {

    @Autowired
    ClassYearRepository classYearRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public ClassYear addClassYear(ClassYear classYear) {
        return classYearRepository.save(classYear);
    }

    @Override
    public ClassYear getClassYearById(int classYearId) {
        return classYearRepository.findById(classYearId).get();
    }

    @Override
    public void deleteClassYearById(int classYearId) {
        classYearRepository.deleteById(classYearId);
    }

    @Override
    public List<ClassYear> getAllClassYears() {
        return classYearRepository.findAll();
    }

    @Override
    public ClassYear addClassYearToStudent(int studentId, int classYearId) {
        Student student = studentRepository.findById(studentId).get();
        ClassYear classYear = classYearRepository.findById(classYearId).get();
        student.setClassYear(classYear);
        studentRepository.save(student);
        return classYear;
    }


}