package com.codals.greating.admin.dto;

import java.util.List;

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
public class AdminDailyDietResponseDto {

	
	private Integer id;
	private Integer diet_id;
	private String diet_name;
	private String main_category_name;
	private String sub_cateogory_name;
	
}
