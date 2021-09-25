package com.eduflex.eduflexbackend.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;
    private Date attendanceDate;

    @OneToMany(mappedBy = "attendance", cascade = CascadeType.ALL)
    @ToString.Exclude
    List<AttendanceReport> attendanceReportList;

    @OneToOne
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    @ToString.Exclude
    private Subject subject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Attendance that = (Attendance) o;
        return Objects.equals(attendanceId, that.attendanceId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
