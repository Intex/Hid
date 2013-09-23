package com.intexsoft.sensor.controller;

public class JsonResponse {	
	public static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
	public static final String DEFAULT_FAIL_MESSAGE = "FAIL";
	
	private String message = DEFAULT_SUCCESS_MESSAGE;
	private boolean success = true;
	private Object data;
	
	public JsonResponse(Object data, String message, boolean success) {
		this.data = data;
		this.message = message;
		this.success = success;
	}
	
	public JsonResponse(Object data, String message) {
		this(true);
		this.data = data;
		this.message = message;
	}
	
	public JsonResponse(Object data, boolean success) {
		this(success);
		this.data = data;
	}	
	
	public JsonResponse(Object data) {
		this.data = data;
	}	
	
	public JsonResponse(String message) {
		this.message = message;
	}
	
	public JsonResponse(boolean success) {
		if (!success) {
			this.message = DEFAULT_FAIL_MESSAGE;
		}
		this.success = success;
	}
	
	public JsonResponse(String message, boolean success) {
		this(success);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}		
}
