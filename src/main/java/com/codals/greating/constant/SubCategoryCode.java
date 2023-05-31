package com.codals.greating.constant;

import lombok.Getter;

@Getter
public enum SubCategoryCode {
	// 건강 식단
	LOW_SUGAR_DIET(1, 1, "LOW_SUGAR_DIET", "저당식단"),
	CALORIE_DIET(2, 1, "CALORIE_DIET", "칼로리식단"),
	LONGEVITY_DIET(3, 1, "LONGEVITY_DIET", "장수마을식단"),
	HIGH_PROTEIN_DIET(4, 1, "HIGH_PROTEIN_DIET", "고단백식단"),
	
	// 질환맞춤식단
	DIABETIC_DIET(5, 2, "DIABETIC_DIET", "당뇨식단"),
	CANCER_DIET(6, 2, "CANCER_DIET", "암환자식단"),
	RENAL_DISEASE_DIET(7, 2, "RENAL_DISEASE_DIET", "신장질환식단"),
	
	// 건강 식단
	BEAUTY_FIT(10, 3, "BEAUTY_FIT", "뷰티핏"),
	VEGI_LIFE(11, 3, "VEGI_LIFE", "베지라이프"),
	PROTEIN_UP(12, 3, "PROTEIN_UP", "프로틴업");
	
	private SubCategoryCode(int id, int mainCategoryId, String code, String koreanName) {
        this.id = id;
        this.mainCategoryId = mainCategoryId;
        this.code = code;
        this.koreanName = koreanName;
    }
	
	private final int id;
	private final int mainCategoryId;
	private final String code;
	private final String koreanName;
}
