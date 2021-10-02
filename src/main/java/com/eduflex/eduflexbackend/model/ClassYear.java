package com.eduflex.eduflexbackend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class ClassYear {

    @OneToMany(mappedBy = "classYear")
    @ToString.Exclude
    List<Student> studentList;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int classYearId;
    @Temporal(TemporalType.DATE)
    private Date classYearStartDate;
    @Temporal(TemporalType.DATE)
    private Date classYearEndDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClassYear classYear = (ClassYear) o;
        return Objects.equals(classYearId, classYear.classYearId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
