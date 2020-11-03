package com.cg.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	private int status;

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String message;
	private long timeStamp;
	private LocalDateTime errorTime;

	
	public ErrorResponse(int status, String message, long timeStamp, LocalDateTime errorTime) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
		this.errorTime = errorTime;
	}

	public LocalDateTime getErrorTime() {
		return errorTime.now();
	}

	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
