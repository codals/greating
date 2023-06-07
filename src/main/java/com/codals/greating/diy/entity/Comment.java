package com.codals.greating.diy.entity;

import java.sql.Timestamp;

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
public class Comment {

	private Integer id;
	private Integer userId;
	private Integer postId;
	private String content;
	private Timestamp createdAt;
}
