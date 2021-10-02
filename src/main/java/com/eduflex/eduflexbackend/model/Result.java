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
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resultId;
    private Double resultMarks;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Result result = (Result) o;
        return Objects.equals(resultId, result.resultId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
