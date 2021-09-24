package com.eduflex.eduflexbackend.service.impl;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.StudentFeedback;
import com.eduflex.eduflexbackend.repository.StudentFeedbackRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.StudentFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentFeedbackServiceImpl implements StudentFeedbackService {

    @Autowired
    StudentFeedbackRepository studentFeedbackRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentFeedback addStudentFeedbackToStudent(int studentId, StudentFeedback studentFeedback) {
        Student student = studentRepository.findById(studentId).get();
        studentFeedback.setStudent(student);
        return studentFeedbackRepository.save(studentFeedback);
    }

    @Override
    public StudentFeedback getStudentFeedbackByStudentFeedbackId(int studentFeedbackId) {
        return studentFeedbackRepository.findById(studentFeedbackId).get();
    }

    @Override
    public List<StudentFeedback> getStudentFeedbacksByStudentId(int studentId) {
        Student student = studentRepository.findById(studentId).get();
        return studentFeedbackRepository.findStudentFeedbacksByStudent(student);
    }

    @Override
    public List<StudentFeedback> getAllStudentFeedbacks() {
        return studentFeedbackRepository.findAll();
    }

    @Override
    public void deleteStudentFeedbackByStudentId(int studentId, int studentFeedbackId) {
        Student student = studentRepository.findById(studentId).get();
        List<StudentFeedback> studentFeedbackList = studentFeedbackRepository.findStudentFeedbacksByStudent(student);
        for (StudentFeedback studentFeedback : studentFeedbackList) {
            if (studentFeedback.getStudentFeedbackId() == studentFeedbackId) {
                studentFeedbackRepository.deleteById(studentFeedback.getStudentFeedbackId());
            }
        }
    }

    @Override
    public void deleteStudentFeedbackByStudentFeedbackId(int studentFeedbackId) {
        studentFeedbackRepository.deleteById(studentFeedbackId);
    }
}
