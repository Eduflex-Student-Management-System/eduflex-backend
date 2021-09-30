package com.eduflex.eduflexbackend.exception;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eduflex.eduflexbackend.exception.DTO.EduflexResponseDTO;

@RestControllerAdvice
public class EduflexExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = EduflexDataNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(EduflexDataNotFoundException e, WebRequest request){
		return new ResponseEntity<Object>(new EduflexResponseDTO(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(value = MethodArgumentNotValidException.class)
//	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
//		HashMap<String, String> map = new HashMap<>();
//		e.getBindingResult().getAllErrors().forEach(error->{
//			String fieldName = ((FieldError) error).getField();
//			String errorMsg = error.getDefaultMessage();
//			map.put(fieldName, errorMsg);
//		});
//		return new ResponseEntity<Object>.status(HttpStatus.BAD_REQUEST).body(
//				EduflexResponseDTO.builder()
//				.message("Some fields Have invalid values")
//				.
//				)
//	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>(new EduflexResponseDTO(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
	}
	
	
}

