package com.codals.greating.diet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {

	private Integer id;
	private Integer mainCategoryId;
	private String name;
	
}
