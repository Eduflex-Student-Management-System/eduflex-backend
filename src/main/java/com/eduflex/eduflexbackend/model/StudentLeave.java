package com.eduflex.eduflexbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class StudentLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentLeaveId;

    @Temporal(TemporalType.DATE)
    private Date studentLeaveDate;
    private boolean studentLeaveStatus = false;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    @ToString.Exclude
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentLeave that = (StudentLeave) o;
        return Objects.equals(studentLeaveId, that.studentLeaveId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
