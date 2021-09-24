package com.eduflex.eduflexbackend.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String facultyAvtar;
	
	@OneToMany(mappedBy="faculty" ,cascade=CascadeType.ALL)
	List<FacultyLeave> facultyLeaveList;
	
	@OneToMany(mappedBy="faculty",cascade=CascadeType.ALL)
	List<FacultyFeedback> facultyFeedbackList;
	
    @OneToMany(mappedBy = "faculty" ,cascade=CascadeType.ALL)
    List<Subject> subjectsList;

}
