package com.simplesns.global;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	NOT_FOUND_USER(404, "해당 유저가 없습니다."),
	DUPLICATE_NICKNAME(400, "이미 가입한 닉네임입니다."),
	FORBIDDEN_NICKNAME(400, "금지된 닉네임입니다.");

	private final int status;
	private final String message;

}
