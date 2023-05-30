package com.codals.greating.diy.service;

import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.user.entity.User;

public interface DiyService {

	PostResponseDto getPostDetail(int postId);

	Integer savePost(User loginUser, DiyRequestDto newPost, String path);
	
}
