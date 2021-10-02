package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.Attendance;
import com.eduflex.eduflexbackend.repository.AttendanceRepository;
import com.eduflex.eduflexbackend.repository.SubjectRepository;
import com.eduflex.eduflexbackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/attendance/{attendanceId}")
    public Attendance getAttendanceById(@PathVariable int attendanceId) {
        return attendanceService.getAttendanceById(attendanceId);
    }

    @PutMapping("/attendance/subject/{subjectId}")
    public Attendance addSubjectToAttendance(@PathVariable int subjectId, @RequestBody Attendance Attendance) {
        return attendanceService.addSubjectToAttendance(subjectId, Attendance);
    }

    @DeleteMapping("/attendance/{attendanceId}")
    public void deleteAttendanceByAttendanceId(@PathVariable int attendanceId) {
        attendanceService.deleteAttendanceByAttendanceId(attendanceId);
    }

    @GetMapping("/attendances")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }
}
