package com.eduflex.eduflexbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Course {
	@Id
	@GeneratedValue
	private int courseId;
	private String courseName;
	
}

