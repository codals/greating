package com.codals.greating.admin.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
	private long id;
	private long userId;
	private String username;
	private String title;
	private int mainCategoryId;
	private int subCategoryId;
	private String mainCategoryName;
	private String subCategoryName;
	private int voteCnt;
	private int status;
	private String createdAt;
}
