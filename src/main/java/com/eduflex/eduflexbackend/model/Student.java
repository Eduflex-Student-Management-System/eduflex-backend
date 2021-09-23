package com.eduflex.eduflexbackend.model;

import lombok.*;
import org.hibernate.Hibernate;

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
