package com.apipaygoal.model.response;

public enum ErrorMessagesProduct {

	RECORD_ALREADY_EXISTS("Ya existe ese registro"),
	NO_RECORD_FOUND("No se encontro ningun registro");

	private String errorMessage;

	ErrorMessagesProduct(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
