package com.codals.greating.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MainCategoryCode {
	HEALTHY_DIET(1, "건강식단", "HD"),
	MEDICAL_DIET(2, "질환맞춤식단", "MD"),
	CHALLENGE_DIET(3, "챌린지식단", "CD");
	
	private final int id;
	private final String koreanName;
	private final String cacheCode;
}
