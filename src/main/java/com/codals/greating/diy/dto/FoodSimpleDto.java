package com.codals.greating.diy.dto;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
public class FoodSimpleDto {
	private int id;
	private String name;
	private String imgUrl;
}
