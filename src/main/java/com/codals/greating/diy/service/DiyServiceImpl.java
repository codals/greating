package com.codals.greating.diy.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codals.greating.diy.dao.DiyDAO;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.VoteRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class DiyServiceImpl implements DiyService{


	private final DiyDAO diyDAO;
	
	@Override
	public PostResponseDto getPostDetail(int postId) {

		return diyDAO.selectPostByPostId(postId);
	}

	@Override
	public void createPost(DiyRequestDto newPost, String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public int votePost(VoteRequestDTO requestDTO) {
		try {
			return  diyDAO.processVote(requestDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
