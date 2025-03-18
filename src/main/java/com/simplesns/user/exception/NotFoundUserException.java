package com.simplesns.user.exception;

import com.simplesns.global.CustomException;
import com.simplesns.global.ErrorCode;

public class NotFoundUserException extends CustomException {
	public NotFoundUserException() {
		super(ErrorCode.NOT_FOUND_USER);
	}
}
