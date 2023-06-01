package com.codals.greating.food.dto;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
public class FoodSimpleDto {
	private Integer id;
	private String name;
	private String imgUrl;
}
