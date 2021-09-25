package com.eduflex.eduflexbackend.service.impl;

import com.eduflex.eduflexbackend.model.Attendance;
import com.eduflex.eduflexbackend.model.Subject;
import com.eduflex.eduflexbackend.repository.AttendanceRepository;
import com.eduflex.eduflexbackend.repository.SubjectRepository;
import com.eduflex.eduflexbackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public void deleteAttendanceByAttendanceId(int attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }

    @Override
    public Attendance getAttendanceById(int attendanceId) {
        return attendanceRepository.findById(attendanceId).get();
    }

    @Override
    public Attendance addSubjectToAttendance(int subjectId, Attendance attendance) {
        Subject subject = subjectRepository.findById(subjectId).get();
        attendance.setSubject(subject);
        return attendanceRepository.save(attendance);
    }
}
