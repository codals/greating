package com.codals.greating.diy.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.codals.greating.diy.dao.DiyDao;
import com.codals.greating.diy.dto.PostResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiyServiceImpl implements DiyService{

	Logger log = LogManager.getLogger("case3");

	private final DiyDao diyDao;
	
	@Override
	public PostResponseDto getPostDetail(int postId) {

		return diyDao.selectPostByPostId(postId);
	}

}
