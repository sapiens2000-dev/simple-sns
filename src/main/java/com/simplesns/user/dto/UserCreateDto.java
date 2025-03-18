package com.simplesns.user.dto;

import com.simplesns.user.annotation.ValidNickname;

public record UserCreateDto(
	@ValidNickname String nickname,
	String password
) {
}
