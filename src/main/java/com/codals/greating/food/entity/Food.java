package com.codals.greating.food.entity;

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
public class Food {
	private Integer id;
	private Integer foodTypeId;
	private String name;
	private Integer price;
	private String description;
	private String imgUrl;
	private Integer inMarket;
}
