package com.simplesns.user.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplesns.user.dto.UserCreateDto;
import com.simplesns.user.dto.UserResponseDto;
import com.simplesns.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(
		@Valid @RequestBody final UserCreateDto userCreateDto

	) {
		userService.createUser(userCreateDto);
	}

	@GetMapping("/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public UserResponseDto getUser(
		@PathVariable final Long userId
	) {
		return userService.getUser(userId);
	}
}
