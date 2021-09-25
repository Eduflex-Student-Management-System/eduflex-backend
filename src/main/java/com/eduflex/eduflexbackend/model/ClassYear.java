package com.eduflex.eduflexbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class ClassYear {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int classYearId;

    @Temporal(TemporalType.DATE)
    private Date classYearStartDate;
    @Temporal(TemporalType.DATE)
    private Date classYearEndDate;


    @OneToMany(mappedBy="classYear", cascade = CascadeType.ALL)
    @ToString.Exclude
    List<Student> studentList;

}
