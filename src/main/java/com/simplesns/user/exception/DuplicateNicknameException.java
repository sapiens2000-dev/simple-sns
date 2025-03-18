package com.simplesns.user.exception;

import com.simplesns.global.CustomException;
import com.simplesns.global.ErrorCode;

public class DuplicateNicknameException extends CustomException {

	public DuplicateNicknameException() {
		super(ErrorCode.DUPLICATE_NICKNAME);
	}
}
