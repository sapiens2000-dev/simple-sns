package com.simplesns.user.exception;

import com.simplesns.global.CustomException;
import com.simplesns.global.ErrorCode;

public class ForbiddenNicknameException extends CustomException {
	public ForbiddenNicknameException() {
		super(ErrorCode.FORBIDDEN_NICKNAME);
	}
}
