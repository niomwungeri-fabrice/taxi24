/**
 * 
 */
package com.taxi24.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author niyomwungeri
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String message) {
	    super(message);
	    }
}
