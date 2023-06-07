package com.codals.greating.diy.dto;


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
public class CommentResponseDto {

	private Integer id;
	private Integer userId;
	private String username;
	private Integer postId;
	private String content;
	private Timestamp createdAt;
}
