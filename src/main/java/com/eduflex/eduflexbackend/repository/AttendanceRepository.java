package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.Attendance;
import com.eduflex.eduflexbackend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    Attendance findAttendanceBySubject(Subject subject);
}
