package com.codals.greating.diy.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.codals.greating.diy.dao.DiyDAO;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiyServiceImpl implements DiyService{

	Logger log = LogManager.getLogger("case3");

	private final DiyDAO diyDAO;
	
	@Override
	public PostResponseDto getPostDetail(int postId) {

		return diyDAO.selectPostByPostId(postId);
	}

	@Override
	public void createPost(DiyRequestDto newPost, String path) {
		// TODO Auto-generated method stub
		
	}

}
