package com.apipaygoal.model.response;

import java.util.Date;

public class ErrorMessageResponseModel {

	private Date timestamp;
	private String message;

	public ErrorMessageResponseModel(Date timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
