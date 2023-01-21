package com.sas.cache.exception;

import org.springframework.http.HttpStatus;

public class Response {

	private HttpStatus status;
	private int code;
	private String message = "Please try Later";
	private Object responseObject;

	public HttpStatus getStatus() {
		return status;
	}

	public Response() {
	}

	public Response(String message, Object responseObject, HttpStatus status) {
		this.message = message;
		this.status = status;
		this.code = status.value();
		this.responseObject = responseObject;
	}

	public Response(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
		this.code = status.value();
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

}
