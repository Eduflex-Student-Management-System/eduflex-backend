package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.AttendanceReport;

import java.util.List;

public interface AttendanceReportService {
    AttendanceReport addAttendanceAndStudentToAttendanceReport(AttendanceReport attendanceReport, int studentId, int attendanceId);
    AttendanceReport updateAttendanceReport(AttendanceReport attendanceReport);
    List<AttendanceReport> getAllAttendanceReports();
    List<AttendanceReport> getAttendanceReportsByStudentId(int studentId);
    List<AttendanceReport> getAttendanceReportsByAttendanceId(int attendanceId);
    void deleteAttendanceReportByAttendanceReportId(int attendanceReportId);
}
