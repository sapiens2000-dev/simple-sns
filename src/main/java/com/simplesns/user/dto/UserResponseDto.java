package com.simplesns.user.dto;

import com.simplesns.user.domain.User;

public record UserResponseDto(
	String nickname
) {
	public static UserResponseDto fromEntity(User user) {
		return new UserResponseDto(user.getNickname());
	}
}
