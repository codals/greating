package com.codals.greating.diy.dto;

import java.util.List;

import com.codals.greating.constant.FoodCountryCode;
import com.codals.greating.constant.MainCategoryCode;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
	
	private List<MainCategoryCode> mainCategories;
	private List<FoodCountryCode> foodCountries;
	
	private Integer hasRice;
	private Integer hasSoup;

}
