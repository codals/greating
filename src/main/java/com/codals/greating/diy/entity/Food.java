                            package com.codals.greating.diy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
	private int id;
	private int foodId;
	private String name;
	private int price;
	private String description;
	private String imgUrl;
	private int inMarket;
}
