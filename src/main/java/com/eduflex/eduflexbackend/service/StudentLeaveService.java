package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.StudentLeave;

import java.util.List;

public interface StudentLeaveService {
    StudentLeave addStudentLeaveToStudent(int studentId, StudentLeave studentLeave);
    void deleteStudentLeave(int studentId, int studentLeaveId);
    List<StudentLeave> getStudentLeavesByStudentId(int studentId);
    StudentLeave getStudentLeaveByStudentLeaveId(int studentId ,int studentLeaveId);
}
