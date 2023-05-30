package com.codals.greating.diy.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.codals.greating.diy.dto.PostResponseDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DiyDaoImpl implements DiyDao{
	
	private final SqlSession sqlSession;
	
	Logger log = LogManager.getLogger("case3");


	@Override
	public <Optional>PostResponseDto selectPostByPostId(int postId) {;
		String statement = "post.selectPostByPostId";

		return sqlSession.selectOne(statement, postId);
	
	}

}
