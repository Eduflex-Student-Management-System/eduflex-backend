package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.Attendance;
import com.eduflex.eduflexbackend.repository.AttendanceRepository;
import com.eduflex.eduflexbackend.repository.SubjectRepository;
import com.eduflex.eduflexbackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    	if(!attendanceRepository.existsById(attendanceId)) {
    		throw new EduflexDataNotFoundException("Can't find attendance with attendanceId: "+attendanceId+", please insert first");
    	}

        return attendanceService.getAttendanceById(attendanceId);
    }

    @PutMapping("/attendance/subject/{subjectId}")
    public Attendance addSubjectToAttendance(@PathVariable int subjectId, @RequestBody Attendance Attendance) {
    	if(!subjectRepository.existsById(subjectId)) {
    		throw new EduflexDataNotFoundException("subjectId  "+subjectId+" can't be inserted to Attendance, because studentId not found");
    	}
        return attendanceService.addSubjectToAttendance(subjectId, Attendance);
    }

    @DeleteMapping("/attendance/{attendanceId}")
    public void deleteAttendanceByAttendanceId(@PathVariable int attendanceId) {
    	if(!attendanceRepository.existsById(attendanceId)) {
    		throw new EduflexDataNotFoundException("Can't delete attendance, attendaceId: "+attendanceId+" not persent in database");
    	}
        attendanceService.deleteAttendanceByAttendanceId(attendanceId);
    }

    @GetMapping("/attendances")
    public List<Attendance> getAllAttendances() {
    	if(attendanceRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Attendance Not Found, Add attendance first");
		}
        return attendanceService.getAllAttendances();
    }
}
