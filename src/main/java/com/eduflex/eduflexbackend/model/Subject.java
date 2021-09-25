package com.eduflex.eduflexbackend.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;

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
public class Subject {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int subjectId;
	private String subjectName;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "facultyId", referencedColumnName = "facultyId")
	private Faculty faculty;
}
