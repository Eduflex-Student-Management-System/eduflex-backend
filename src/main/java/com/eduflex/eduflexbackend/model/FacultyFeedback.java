package com.eduflex.eduflexbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class FacultyFeedback {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int facultyFeedbackId;
    private String facultyFeedback;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facultyId", referencedColumnName = "facultyId")
    private Faculty faculty;
}
