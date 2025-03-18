package com.simplesns.user.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.simplesns.user.UserRepository;
import com.simplesns.user.domain.User;
import com.simplesns.user.dto.UserCreateDto;
import com.simplesns.user.exception.DuplicateNicknameException;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;

	@Test
	@DisplayName("유저가 생성되어야 한다.")
	@Transactional
	void createUserSuccess() {
		UserCreateDto userCreateDto = new UserCreateDto(
			"test1",
			"12345678"
		);

		userService.createUser(userCreateDto);

		User savedUser = userRepository.findByNickname(userCreateDto.nickname()).orElse(null);
		assertEquals(userCreateDto.nickname(), savedUser.getNickname());

	}

	@Test
	@DisplayName("중복 닉네임인 경우 DuplicateNicknameException이 발생해야 한다.")
	@Transactional
	void createUserFailureWithDuplicateNickname() {
		UserCreateDto userCreateDto1 = new UserCreateDto(
			"test1",
			"12345678"
		);

		UserCreateDto userCreateDto2 = new UserCreateDto(
			"test1",
			"12345678"
		);

		userService.createUser(userCreateDto1);
		assertThrows(DuplicateNicknameException.class,
			() -> userService.createUser(userCreateDto2));
	}

	// @Test
	// @DisplayName("금지된 닉네임인 경우 ForbiddenNicknameException이 발생해야 한다.")
	// @Transactional
	// void createUserFailureWithForbiddenNickname() {
	// 	UserCreateDto userCreateDto = new UserCreateDto(
	// 		"ㅅㅂ",
	// 		"12345678"
	// 	);
	//
	// 	assertThrows(ForbiddenNicknameException.class,
	// 		() -> userService.createUser(userCreateDto));
	// }

	@Test
	@DisplayName("유저 정보가 조회되어야 한다.")
	@Transactional
	void getUserSuccess() {
		UserCreateDto userCreateDto = new UserCreateDto(
			"test1",
			"12345678"
		);

		userService.createUser(userCreateDto);

		User user = userRepository.findByNickname(userCreateDto.nickname()).orElse(null);

		assertEquals(userCreateDto.nickname(), user.getNickname());
		assertEquals(userCreateDto.password(), user.getPassword());

	}

}