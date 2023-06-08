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
	private long id;
	private String userName;
	private String title;
	private long minCalorie;
	private long maxCalorie;
	private long maxPrice;
	private String imgUrl;
	// Paging
    private int startRow;
    private int endRow;
	private int page;
	private int totalPage;
	private int totalCount;
}
