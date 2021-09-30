package com.eduflex.eduflexbackend.exception.DTO;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EduflexResponseDTO {
	private String message;
	private HttpStatus httpStatus;	
	private LocalDateTime timeStamp;
}
