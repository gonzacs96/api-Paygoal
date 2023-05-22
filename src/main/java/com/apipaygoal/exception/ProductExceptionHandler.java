package com.apipaygoal.exception;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.apipaygoal.model.response.ErrorMessageResponseModel;
import com.apipaygoal.model.response.ErrorMessageValidationResponseModel;

@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {

	DefaultErrorAttributes bodyException;

	@ExceptionHandler(value = { ProductServiceException.class })
	public ResponseEntity<Object> handleProductExistException(ProductServiceException ex, WebRequest request) {
		ErrorMessageResponseModel errorMessage = new ErrorMessageResponseModel(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.toList());

		ErrorMessageResponseModel errorResponse = new ErrorMessageValidationResponseModel(new Date(), "Validation Failed",
				errors);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
