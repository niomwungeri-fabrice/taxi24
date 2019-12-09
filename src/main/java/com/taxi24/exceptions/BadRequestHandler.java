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
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestHandler extends Exception{
	private static final long serialVersionUID = 1L;

	public BadRequestHandler(String message) {
	    super(message);
	  }
}
