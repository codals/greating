package com.codals.greating.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPageDto {

	private long id;
	private long userId;
	private int postId;
	private String title;
	private String imgUrl;
	private int voteCnt;
	private String riceFoodName;
    private String soupFoodName;
    private String mainFoodName;
    private String side1FoodName;
    private String side2FoodName;
    private String extraFoodName;
    
	// Paging
    private int startRow;
    private int endRow;
	private int page;
	private int totalPage;
	private int totalCount;
}

