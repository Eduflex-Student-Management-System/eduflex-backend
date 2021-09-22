package com.eduflex.eduflexbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table
public class Session {
	@Id
	@GeneratedValue
	private int sessionId;
	@Column
	@Type(type="timestamp")
	private Date sessionDateTime;
}
