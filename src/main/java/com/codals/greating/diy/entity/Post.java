package com.codals.greating.diy.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Post {
	private Integer id;
	
	private Integer mainCategoryId;
	private Integer subCategoryId;
	private Integer foodCountryId;
	private Integer userId;
	private String username;
	private String title;
	private String content;
	private String imgUrl;
	private Integer riceFoodId;
	private Integer soupFoodId;
	private Integer mainFoodId;
	private Integer side1FoodId;
	private Integer side2FoodId;
	private Integer extraFoodId;
	private Integer minCalorie;
	private Integer maxCalorie;
	private Integer minPrice;
	private Integer maxPrice;
	private Integer voteCnt;
	private Integer status;
	private Timestamp createdAt;
	private Timestamp modifiedAt;

}
