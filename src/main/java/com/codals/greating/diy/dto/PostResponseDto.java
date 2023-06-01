package com.codals.greating.diy.dto;

import com.codals.greating.diet.entity.MainCategory;
import com.codals.greating.diet.entity.SubCategory;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.food.entity.Food;
import com.codals.greating.user.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {
	
	private Post post;
	
	private User user;
	
	private MainCategory mainCategory;
	private SubCategory subCategory;
	
	private Food rice;
	private Food soup;
	private Food main;
	private Food side1;
	private Food side2;
	private Food extra;
	

}
