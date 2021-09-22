package com.eduflex.eduflexbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	@GeneratedValue
	private int facultyId;
	private String facultyName;
	private String facultyUsername;
	private String facultyPassword;
	private String facultyCity;
	@Lob
	@Column(columnDefinition = "CLOB")
	private String facultyAvtar;
	
	
	

}
