package com.eduflex.eduflexbackend.service.impl;

import com.eduflex.eduflexbackend.model.Attendance;
import com.eduflex.eduflexbackend.model.AttendanceReport;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.AttendanceReportRepository;
import com.eduflex.eduflexbackend.repository.AttendanceRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.AttendanceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceReportServiceImpl implements AttendanceReportService {

    @Autowired
    AttendanceReportRepository attendanceReportRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public AttendanceReport addAttendanceAndStudentToAttendanceReport(AttendanceReport attendanceReport, int studentId, int attendanceId) {
        Student student = studentRepository.findById(studentId).get();
        Attendance attendance = attendanceRepository.findById(attendanceId).get();
        attendanceReport.setStudent(student);
        attendanceReport.setAttendance(attendance);
        return attendanceReportRepository.save(attendanceReport);
    }

    @Override
    public AttendanceReport updateAttendanceReport(AttendanceReport attendanceReport) {
        return attendanceReportRepository.save(attendanceReport);
    }

    @Override
    public List<AttendanceReport> getAllAttendanceReports() {
        return attendanceReportRepository.findAll();
    }

    @Override
    public List<AttendanceReport> getAttendanceReportsByStudentId(int studentId) {
        Student student = studentRepository.findById(studentId).get();
        return attendanceReportRepository.findAttendanceReportsByStudent(student);
    }

    @Override
    public List<AttendanceReport> getAttendanceReportsByAttendanceId(int attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId).get();
        return attendanceReportRepository.findAttendanceReportsByAttendance(attendance);
    }

    @Override
    public void deleteAttendanceReportByAttendanceReportId(int attendanceReportId) {
        attendanceReportRepository.deleteById(attendanceReportId);
    }
}
