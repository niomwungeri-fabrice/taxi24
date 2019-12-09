/**
 * 
 */
package com.taxi24.exceptions;

import java.util.Date;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * @author niyomwungeri
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		    GenericErrorResponse genericErrorResponse = new GenericErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.toString(), new Date());
		    return new ResponseEntity<>(genericErrorResponse, HttpStatus.NOT_FOUND);
		}
}
