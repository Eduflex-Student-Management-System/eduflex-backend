package com.eduflex.eduflexbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class FacultyLeave {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int facultyLeaveId;

    @Temporal(TemporalType.DATE)
    private Date facultyLeaveStartDate;

    @Temporal(TemporalType.DATE)
    private Date facultyLeaveEndDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facultyId", referencedColumnName = "facultyId")
    private Faculty faculty;
    private boolean facultyLeaveStatus = false;
}
