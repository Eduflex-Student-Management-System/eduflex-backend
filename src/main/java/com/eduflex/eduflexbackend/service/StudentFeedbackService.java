package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.StudentFeedback;

import java.util.List;

public interface StudentFeedbackService {
    StudentFeedback addStudentFeedbackToStudent(int studentId, StudentFeedback studentFeedback);

    StudentFeedback getStudentFeedbackByStudentFeedbackId(int studentFeedbackId);

    List<StudentFeedback> getStudentFeedbacksByStudentId(int studentId);

    List<StudentFeedback> getAllStudentFeedbacks();

    void deleteStudentFeedbackByStudentId(int studentId, int studentFeedbackId);

    void deleteStudentFeedbackByStudentFeedbackId(int studentFeedbackId);
}
