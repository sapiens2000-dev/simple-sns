package com.simplesns.user.service;

import org.springframework.stereotype.Service;

import com.simplesns.user.UserRepository;
import com.simplesns.user.domain.User;
import com.simplesns.user.dto.UserCreateDto;
import com.simplesns.user.dto.UserResponseDto;
import com.simplesns.user.exception.DuplicateNicknameException;
import com.simplesns.user.exception.NotFoundUserException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	@Transactional
	public void createUser(UserCreateDto userCreateDto) {
		validateNickname(userCreateDto.nickname());
		User user = User.create(userCreateDto);
		userRepository.save(user);
	}

	public UserResponseDto getUser(Long userId) {
		return UserResponseDto.fromEntity(
			userRepository.findById(userId).orElseThrow(
				NotFoundUserException::new
			));
	}

	public void validateNickname(String nickname) {
		userRepository.findByNickname(nickname)
			.ifPresent(o -> {
				throw new DuplicateNicknameException();
			});
	}
}
