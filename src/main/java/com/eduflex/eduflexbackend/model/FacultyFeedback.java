package com.eduflex.eduflexbackend.model;

import javax.persistence.FetchType;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
