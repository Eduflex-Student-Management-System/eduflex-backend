package com.eduflex.eduflexbackend.service.impl;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.StudentLeave;
import com.eduflex.eduflexbackend.repository.StudentLeaveRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentLeaveServiceImpl implements StudentLeaveService {

    @Autowired
    StudentLeaveRepository studentLeaveRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void deleteStudentLeave(int studentId, int studentLeaveId) {
        Student student = studentRepository.findById(studentId).get();
        List<StudentLeave> studentLeaveList = studentLeaveRepository.findStudentLeavesByStudent(student);
        for(StudentLeave studentLeave : studentLeaveList) {
            if(studentLeave.getStudentLeaveId() == studentLeaveId) {
                studentLeaveRepository.deleteById(studentLeaveId);
            }
        }
    }

    @Override
    public List<StudentLeave> getStudentLeavesByStudentId(int studentId) {
        Student student = studentRepository.findById(studentId).get();
        return studentLeaveRepository.findStudentLeavesByStudent(student);
    }

    @Override
    public StudentLeave getStudentLeaveByStudentLeaveId(int studentId, int studentLeaveId) {
        return studentLeaveRepository.findById(studentLeaveId).get();
    }

    @Override
    public StudentLeave addStudentLeaveToStudent(int studentId, StudentLeave studentLeave) {
        Student student = studentRepository.findById(studentId).get();
        studentLeave.setStudent(student);
        return studentLeaveRepository.save(studentLeave);
    }
}
