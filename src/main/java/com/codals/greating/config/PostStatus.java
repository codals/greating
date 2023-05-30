package com.codals.greating.config;

import lombok.Getter;

@Getter
public enum PostStatus {
	VOTE_IN_PROGRESS(1, "VOTE_IN_PROGRESS", "투표중"),
	VOTE_FINISHED(0, "VOTE_FINISHED", "투표 종료");
	
	private PostStatus(int id, String code, String koreanName) {
        this.id = id;
        this.code = code;
        this.koreanName = koreanName;
    }
	
	private final int id;
	private final String code;
	private final String koreanName;
}
