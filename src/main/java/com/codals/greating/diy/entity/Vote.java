package com.codals.greating.diy.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vote {

	private Integer id;
	private Integer postId;
	private Integer userId;
}
