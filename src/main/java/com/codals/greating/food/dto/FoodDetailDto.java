package com.codals.greating.food.dto;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
public class FoodDetailDto {
	private Integer id;
	private String name;
	private String imgUrl;
	private Integer price;
	private String description;
}
