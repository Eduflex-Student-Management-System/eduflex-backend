package com.eduflex.eduflexbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Hod {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int hodId;
	private String hodName;
	private String hodUserName;
	private String hodPassword;
	private String hodCity;
	
	@Lob
	@Column(columnDefinition = "CLOB")
	private String hodAvatar;
}
