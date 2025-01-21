package com.edstem.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorHandler> handleGlobalException(Exception ex, WebRequest web) {
		log.error("Exception: {}", ex.getMessage());
		MyErrorHandler error = new MyErrorHandler(ex.getMessage(), web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(EdstemException.class)
	public ResponseEntity<MyErrorHandler> edstemException(EdstemException ex, WebRequest web) {
		log.error("EdstemException: {}", ex.getMessage());
		MyErrorHandler error = new MyErrorHandler(ex.getMessage(), web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(MenuItemException.class)
	public ResponseEntity<MyErrorHandler> menuItemException(MenuItemException ex, WebRequest web) {
		log.error("MenuItemException: {}", ex.getMessage());
		MyErrorHandler error = new MyErrorHandler(ex.getMessage(), web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorHandler> orderExceptionE(OrderException ex, WebRequest web) {
		log.error("OrderException: {}", ex.getMessage());
		MyErrorHandler error = new MyErrorHandler(ex.getMessage(), web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(OrderItemException.class)
	public ResponseEntity<MyErrorHandler> orderItemException(OrderItemException ex, WebRequest web) {
		log.error("OrderItemException: {}", ex.getMessage());
		MyErrorHandler error = new MyErrorHandler(ex.getMessage(), web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorHandler> noHandlerFoundException(NoHandlerFoundException ex, WebRequest web) {
		log.error("NoHandlerFoundException: {}", ex.getMessage());
		MyErrorHandler error = new MyErrorHandler(ex.getMessage(), web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorHandler> methodArgumentNotValidException(MethodArgumentNotValidException ex,
			WebRequest web) {
		log.error("MethodArgumentNotValidException: {}", ex.getMessage());
		MyErrorHandler error = new MyErrorHandler("Method not fund exception", web.getDescription(false),
				LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<MyErrorHandler> methodArgumentNotValidException(HttpMessageNotReadableException ex,
			WebRequest web) {
		log.error("HttpMessageNotReadableException: {}", ex.getMessage());
		MyErrorHandler error = new MyErrorHandler("Invalid Json", web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
