package com.codals.greating.config;

import lombok.Getter;

@Getter
public enum FoodTypeCode {
	RICE(1, "RICE", "밥"),
	SOUP(2, "SOUP", "국"),
	MAIN(3, "MAIN", "메인"),
	SIDE(4, "SIDE", "밥"),
	EXTRA(5, "EXTRA", "밥");
	
	private FoodTypeCode(int id, String code, String koreanName) {
        this.id = id;
        this.code = code;
        this.koreanName = koreanName;
    }
	
	private final int id;
	private final String code;
	private final String koreanName;
}
