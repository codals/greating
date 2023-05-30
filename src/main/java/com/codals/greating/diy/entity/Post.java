package com.codals.greating.diy.entity;

import java.sql.Timestamp;

import com.codals.greating.date.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post extends BaseEntity{

	private Long id;
	private Long mainCategoryId;
	private Long subCategoryId;
	private Long foodCountryId;
	private Long userId;
	private String title;
	private String content;
	private String img_url;
	private Long riceFoodId;
	private Long soupFoodId;
	private Long mainFoodId;
	private Long side1FoodId;
	private Long side2FoodId;
	private Long extraFoodId;
	private int minCalorie;
	private int maxCalorie;
	private int minPrice;
	private int maxPrice;
	private int likeCnt;
	private int status;
	private Timestamp createdAt;
	private Timestamp modifiedAt;

}
