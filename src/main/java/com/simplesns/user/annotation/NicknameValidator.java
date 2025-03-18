package com.simplesns.user.annotation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class NicknameValidator implements ConstraintValidator<ValidNickname, String> {

	private final Set<String> forbidden = new HashSet<>();

	@PostConstruct
	public void init() {
		forbidden.add("ㅅㅂ");
	}

	@Override
	public boolean isValid(String nickname, ConstraintValidatorContext constraintValidatorContext) {
		return !forbidden.contains(nickname);
	}
}
