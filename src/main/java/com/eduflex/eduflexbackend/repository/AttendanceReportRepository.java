package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.Attendance;
import com.eduflex.eduflexbackend.model.AttendanceReport;
import com.eduflex.eduflexbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceReportRepository extends JpaRepository<AttendanceReport, Integer> {
    List<AttendanceReport> findAttendanceReportsByStudent(Student student);
    List<AttendanceReport> findAttendanceReportsByAttendance(Attendance attendance);
}
