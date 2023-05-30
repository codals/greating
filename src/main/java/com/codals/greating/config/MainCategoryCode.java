package com.codals.greating.config;

import lombok.Getter;

@Getter
public enum MainCategoryCode {
	HEALTHY_DIET(1, "HEALTHY_DIET", "건강식단"),
	MEDICAL_DIET(2, "CARE_DIET", "질환맞춤식단"),
	CHALLENGE_DIET(3, "CHALLENGE_DIET", "챌린지식단");
	
	private MainCategoryCode(int id, String code, String koreanName) {
        this.id = id;
        this.code = code;
        this.koreanName = koreanName;
    }
	
	private final int id;
	private final String code;
	private final String koreanName;
}
