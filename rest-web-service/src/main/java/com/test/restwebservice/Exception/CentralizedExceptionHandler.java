package com.test.restwebservice.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.restwebservice.model.GenericErrorResponseModel;

@ControllerAdvice
@RestController
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<GenericErrorResponseModel> hadndleStudentException(StudentNotFoundException ex,
			WebRequest request) {
		GenericErrorResponseModel error = new GenericErrorResponseModel(ex.getMessage(), new Date());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		GenericErrorResponseModel error = new GenericErrorResponseModel(ex.getBindingResult().getFieldError().getField()
				+ " - " + ex.getBindingResult().getFieldError().getDefaultMessage(), new Date());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericErrorResponseModel> hadndleOtherException(Exception ex, WebRequest request) {
		GenericErrorResponseModel error = new GenericErrorResponseModel(ex.getMessage(), new Date());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
