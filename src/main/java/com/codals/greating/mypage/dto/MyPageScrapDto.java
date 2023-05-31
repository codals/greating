package com.codals.greating.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyPageScrapDto {
	private long userId;
	private long postId;
	private String userName;
	private String postTitle;
	private long minCalorie;
	private long maxCalorie;
	private long maxPrice;
}
