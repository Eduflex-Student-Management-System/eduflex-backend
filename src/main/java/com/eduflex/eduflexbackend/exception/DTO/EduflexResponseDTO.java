package com.eduflex.eduflexbackend.exception.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EduflexResponseDTO {
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime timeStamp;
}
