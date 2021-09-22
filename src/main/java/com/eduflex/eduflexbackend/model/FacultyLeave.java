package com.eduflex.eduflexbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@GeneratedValue
	private int facultyLeaveId;
	private Date facultyLeaveDate;
	

}
