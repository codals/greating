package com.codals.greating.config;

import lombok.Getter;

@Getter
public enum FoodCountryCode {
	KOREAN(1, "KOREAN", "한식"),
	CHINESE(2, "CHINESE", "중식"),
	JAPANESE(3, "JAPANESE", "일식"),
	WESTERN(4, "WESTERN", "양식"),
	ETC(5, "ETC", "기타");
	
	private FoodCountryCode(int id, String code, String koreanName) {
        this.id = id;
        this.code = code;
        this.koreanName = koreanName;
    }
	
	private final int id;
	private final String code;
	private final String koreanName;
}
