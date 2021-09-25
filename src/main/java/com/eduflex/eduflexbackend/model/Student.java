package com.eduflex.eduflexbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String studentUsername;
    private String studentPassword;
    private String studentCity;

    @Lob
    @Column(columnDefinition = "CLOB")
    private String studentAvatar;

    @OneToMany(mappedBy="student", cascade = CascadeType.ALL)
    private List<StudentLeave> studentLeaveList;

    @OneToMany(mappedBy="student", cascade = CascadeType.ALL)
    private List<StudentFeedback> studentFeedbackList;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Result result;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="classYearId" , referencedColumnName="classYearId")
    private ClassYear classYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
