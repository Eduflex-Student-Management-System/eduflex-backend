package com.eduflex.eduflexbackend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class Subject {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int subjectId;
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "facultyId", referencedColumnName = "facultyId")
    private Faculty faculty;
}
