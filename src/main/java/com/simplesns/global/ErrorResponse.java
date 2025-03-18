package com.simplesns.global;

public record ErrorResponse(
	int status,
	String message
) {

}