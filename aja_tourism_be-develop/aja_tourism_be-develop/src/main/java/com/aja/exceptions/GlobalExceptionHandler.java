package com.aja.exceptions;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.aja.ErrorResponse.dto.ErrorResponse;

@RestControllerAdvice

public class GlobalExceptionHandler {

	// 1️ Resource not found (Place / Package / Booking not found)

	@ExceptionHandler(RuntimeException.class)

	public ResponseEntity<String> handleNotFound(RuntimeException ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

	}

	// 2️ Validation error (@NotNull, @NotBlank)

	@ExceptionHandler(MethodArgumentNotValidException.class)

	public ResponseEntity<String> handleValidation() {

		return new ResponseEntity<>("Invalid input data", HttpStatus.BAD_REQUEST);

	}

	// 3️ Database constraint issues (FK, duplicate, NOT NULL)

	@ExceptionHandler(DataIntegrityViolationException.class)

	public ResponseEntity<String> handleDBError() {

		return new ResponseEntity<>("Database constraint violation", HttpStatus.CONFLICT);

	}

	// 4️ Wrong ID type in URL (string instead of number)

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)

	public ResponseEntity<String> handleTypeMismatch() {

		return new ResponseEntity<>("Invalid ID format", HttpStatus.BAD_REQUEST);

	}

	// 5️ Wrong HTTP method (GET instead of POST/DELETE)

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)

	public ResponseEntity<String> handleMethodNotAllowed() {

		return new ResponseEntity<>("HTTP method not allowed", HttpStatus.METHOD_NOT_ALLOWED);

	}

	// 6️ Business rule violation (booking rules, date rules)

	@ExceptionHandler(IllegalStateException.class)

	public ResponseEntity<String> handleBusinessRule(IllegalStateException ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

	// 7️ Invalid method arguments

	@ExceptionHandler(IllegalArgumentException.class)

	public ResponseEntity<String> handleIllegalArgument() {

		return new ResponseEntity<>("Invalid argument provided", HttpStatus.BAD_REQUEST);

	}

	// 8️ Invalid JSON request body

	@ExceptionHandler(HttpMessageNotReadableException.class)

	public ResponseEntity<String> handleInvalidJson() {

		return new ResponseEntity<>("Invalid JSON request", HttpStatus.BAD_REQUEST);

	}

	// 9️ Missing request parameter

	@ExceptionHandler(MissingServletRequestParameterException.class)

	public ResponseEntity<String> handleMissingParam() {

		return new ResponseEntity<>("Missing request parameter", HttpStatus.BAD_REQUEST);

	}

	// 10 Unauthorized access (if Spring Security is used)

	@ExceptionHandler(AccessDeniedException.class)

	public ResponseEntity<String> handleAccessDenied() {

		return new ResponseEntity<>("Access denied", HttpStatus.FORBIDDEN);

	}

	// 1️1️ Null pointer (NOT recommended, but shown for knowledge)

	@ExceptionHandler(NullPointerException.class)

	public ResponseEntity<String> handleNullPointer() {

		return new ResponseEntity<>("Null value encountered", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	// 1️2 Fallback for any other error

	@ExceptionHandler(Exception.class)

	public ResponseEntity<String> handleGeneric() {

		return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);

	}
}