package com.eduflex.eduflexbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class Faculty {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int facultyId;
    private String facultyName;
    private String facultyUsername;
    private String facultyPassword;
    private String facultyCity;

    @Lob
    @Column(columnDefinition = "CLOB")
    private String facultyAvatar;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    List<FacultyLeave> facultyLeaveList;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    List<FacultyFeedback> facultyFeedbackList;

    @JsonIgnore
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    List<Subject> subjectsList;
}
