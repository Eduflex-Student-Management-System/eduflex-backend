package com.eduflex.eduflexbackend.model;
import com.eduflex.eduflexbackend.model.Faculty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class FacultyLeave {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int facultyLeaveId;
	
	@Temporal(TemporalType.DATE) 
	private Date facultyLeaveStartDate;
	
	@Temporal(TemporalType.DATE) 
	private Date facultyLeaveEndDate;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="facultyId" , referencedColumnName="facultyId")
	private Faculty faculty;
	private boolean facultyLeaveStatus=false;	
}
