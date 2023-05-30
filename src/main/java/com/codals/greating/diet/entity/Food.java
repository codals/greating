package com.codals.greating.diet.entity;

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

	private Long id;
	private Long foodTypeId;
	private String name;
	private int price;
	private String description;
	private String imgUrl;
	private int inMarket;
}
