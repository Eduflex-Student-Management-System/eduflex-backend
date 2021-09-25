package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.AttendanceReport;
import com.eduflex.eduflexbackend.service.AttendanceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AttendanceReportController {

    @Autowired
    AttendanceReportService attendanceReportService;


    @PutMapping("/attendanceReport/{attendanceId}/{studentId}")
    public AttendanceReport addAttendanceAndStudentToAttendanceReport(@RequestBody AttendanceReport attendanceReport,@PathVariable int studentId,@PathVariable int attendanceId) {
        return attendanceReportService.addAttendanceAndStudentToAttendanceReport(attendanceReport, studentId, attendanceId);
    }

    @PutMapping("/attendanceReport")
    public AttendanceReport updateAttendanceReport(@RequestBody AttendanceReport attendanceReport) {
        return attendanceReportService.updateAttendanceReport(attendanceReport);
    }

    @GetMapping("/attendanceReports")
    public List<AttendanceReport> getAllAttendanceReports() {
        return attendanceReportService.getAllAttendanceReports();
    }

    @GetMapping("/attendanceReport/student/{studentId}")
    public List<AttendanceReport> getAttendanceReportsByStudentId(@PathVariable int studentId) {
        return  attendanceReportService.getAttendanceReportsByStudentId(studentId);
    }

    @GetMapping("/attendanceReport/attendance/{attendanceId}")
    public List<AttendanceReport> getAttendanceReportsByAttendanceId(@PathVariable int attendanceId) {
        return attendanceReportService.getAttendanceReportsByAttendanceId(attendanceId);
    }

    @DeleteMapping("/attendanceReport/{attendanceReportId}")
    public void deleteAttendanceReportByAttendanceReportId(@PathVariable int attendanceReportId) {
        attendanceReportService.deleteAttendanceReportByAttendanceReportId(attendanceReportId);
    }
}
