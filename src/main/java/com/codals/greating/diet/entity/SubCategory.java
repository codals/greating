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

	private Long id;
	private Long mainCategoryId;
	private String name;
	
}
