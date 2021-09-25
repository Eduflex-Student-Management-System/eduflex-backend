package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.StudentLeave;

import java.util.List;

public interface StudentLeaveService {
    StudentLeave addStudentLeaveToStudent(int studentId, StudentLeave studentLeave);
    StudentLeave getStudentLeaveByStudentLeaveId(int studentLeaveId);
    List<StudentLeave> getAllStudentLeaves();
    List<StudentLeave> getStudentLeavesByStudentId(int studentId);
    void deleteStudentLeaveByStudentId(int studentId, int studentLeaveId);
    void deleteStudentLeaveByStudentLeaveId(int studentLeaveId);
}
