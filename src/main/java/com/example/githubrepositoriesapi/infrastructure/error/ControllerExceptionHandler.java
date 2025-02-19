package com.example.githubrepositoriesapi.infrastructure.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserNotFoundExceptionDto> userNotFoundExceptionHandler(UserNotFoundException userNotFoundException) {
        UserNotFoundExceptionDto response = new UserNotFoundExceptionDto(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    public ResponseEntity<MediaTypeExceptionDto> mediaTypeExceptionHandler(HttpMediaTypeException httpMediaTypeException) {
        MediaTypeExceptionDto response = new MediaTypeExceptionDto("Invalid media type in header", HttpStatus.NOT_ACCEPTABLE.value());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
