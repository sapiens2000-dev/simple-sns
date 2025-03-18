package com.simplesns.user.domain;

import com.simplesns.user.dto.UserCreateDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Getter
	@Column(name = "nickname", nullable = false, unique = true)
	@Size(min = 2, max = 20)
	private String nickname;

	@Getter
	@Column(name = "password", nullable = false)
	@Size(min = 8, max = 20)
	private String password;

	@Builder
	User(UserCreateDto userCreateDto) {
		this.nickname = userCreateDto.nickname();
		this.password = userCreateDto.password();
	}

	public static User create(UserCreateDto userCreateDto) {
		return new User(userCreateDto);
	}

}
