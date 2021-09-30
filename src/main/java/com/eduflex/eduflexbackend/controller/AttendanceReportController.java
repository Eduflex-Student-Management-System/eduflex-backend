package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.AttendanceReport;
import com.eduflex.eduflexbackend.repository.AttendanceReportRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.AttendanceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AttendanceReportController {

    @Autowired
    AttendanceReportService attendanceReportService;
    
    @Autowired
    AttendanceReportRepository attendanceReportRepository;
    
    @Autowired
    StudentRepository studentRepository;


    @PutMapping("/attendanceReport/{attendanceId}/{studentId}")
    public AttendanceReport addAttendanceAndStudentToAttendanceReport(@RequestBody AttendanceReport attendanceReport,@PathVariable int studentId,@PathVariable int attendanceId) {
    	if(!attendanceReportRepository.existsById(attendanceId) && !studentRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("AttendanceId  "+attendanceId+" can't be inserted to studentId "+studentId+", because studentId not find");
    	}
        return attendanceReportService.addAttendanceAndStudentToAttendanceReport(attendanceReport, studentId, attendanceId);
    }

    @PutMapping("/attendanceReport")
    public AttendanceReport updateAttendanceReport(@RequestBody AttendanceReport attendanceReport) {
        return attendanceReportService.updateAttendanceReport(attendanceReport);
    }

    @GetMapping("/attendanceReports")
    public List<AttendanceReport> getAllAttendanceReports() {
    	if(attendanceReportRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Attendance Not Found, Add Attendance first");
		}
        return attendanceReportService.getAllAttendanceReports();
    }

    @GetMapping("/attendanceReport/student/{studentId}")
    public List<AttendanceReport> getAttendanceReportsByStudentId(@PathVariable int studentId) {
    	if(!studentRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("Can't delete attendance, studentId: "+studentId+" not persent in database");
    	}
        return  attendanceReportService.getAttendanceReportsByStudentId(studentId);
    }

    @GetMapping("/attendanceReport/attendance/{attendanceId}")
    public List<AttendanceReport> getAttendanceReportsByAttendanceId(@PathVariable int attendanceId) {
    	if(!attendanceReportRepository.existsById(attendanceId)) {
    		throw new EduflexDataNotFoundException("Can't find attendance with attendanceId: "+attendanceId+", please insert first");
    	}
        return attendanceReportService.getAttendanceReportsByAttendanceId(attendanceId);
    }

    @DeleteMapping("/attendanceReport/{attendanceReportId}")
    public void deleteAttendanceReportByAttendanceReportId(@PathVariable int attendanceReportId) {
    	if(!attendanceReportRepository.existsById(attendanceReportId)) {
    		throw new EduflexDataNotFoundException("Can't delete student, studentId: "+attendanceReportId+" not persent in database");
    	}
        attendanceReportService.deleteAttendanceReportByAttendanceReportId(attendanceReportId);
    }
}
