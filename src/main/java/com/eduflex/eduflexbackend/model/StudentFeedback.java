package com.eduflex.eduflexbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class StudentFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentFeedbackId;
    private String studentFeedback;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    @ToString.Exclude
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentFeedback that = (StudentFeedback) o;
        return Objects.equals(studentFeedbackId, that.studentFeedbackId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
