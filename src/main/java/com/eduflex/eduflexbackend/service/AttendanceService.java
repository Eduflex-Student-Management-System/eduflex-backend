package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.Attendance;

import java.util.List;

public interface AttendanceService {
    Attendance getAttendanceById(int attendanceId);
    Attendance addSubjectToAttendance(int subjectId, Attendance Attendance);
    void deleteAttendanceByAttendanceId(int attendanceId);
    List<Attendance> getAllAttendances();
}
