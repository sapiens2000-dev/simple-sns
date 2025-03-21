package com.simplesns.global;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	private final int status;
	private final String message;

	public CustomException(ErrorCode errorCode) {
		this.status = errorCode.getStatus();
		this.message = errorCode.getMessage();
	}
}
