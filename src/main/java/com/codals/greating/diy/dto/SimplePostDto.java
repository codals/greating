package com.codals.greating.diy.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SimplePostDto {

	private Integer id;
	private String title;
	private String imgUrl;
	private Integer maxCalorie;
	private Integer minCalorie;

	private Integer maxPrice;
	private Integer minPrice;
	private Integer voteCnt;
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	
	private String username;
	private String name;

	
}
