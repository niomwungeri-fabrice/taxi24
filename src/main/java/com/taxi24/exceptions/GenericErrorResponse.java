/**
 * 
 */
package com.taxi24.exceptions;

import java.util.Date;

/**
 * @author niyomwungeri
 *
 */
public class GenericErrorResponse {
	
	private String message;
	private String status;
	private Date date;
	
	public GenericErrorResponse(String message, String status, Date date) {
		super();
		this.message = message;
		this.status = status;
		this.date = date;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
