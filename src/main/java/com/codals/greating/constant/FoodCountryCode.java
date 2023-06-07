package com.codals.greating.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodCountryCode {
	KOREAN(1, "한식", "KOR"),
	CHINESE(2, "중식", "CHN"),
	JAPANESE(3, "일식", "JPN"),
	WESTERN(4, "양식", "WEST"),
	ETC(5, "기타", "ETC");

	private final int id;
	private final String koreanName;
	private final String cacheCode;
}
