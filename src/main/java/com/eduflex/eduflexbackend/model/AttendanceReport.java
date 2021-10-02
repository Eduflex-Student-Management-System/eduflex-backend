package com.eduflex.eduflexbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class AttendanceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceReportId;
    private boolean attendanceStatus = false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "attendanceId", referencedColumnName = "attendanceId")
    private Attendance attendance;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AttendanceReport that = (AttendanceReport) o;
        return Objects.equals(attendanceReportId, that.attendanceReportId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
