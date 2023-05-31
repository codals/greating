package com.codals.greating.diy.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.VoteRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class DiyDAOImpl implements DiyDAO {
	
	private final SqlSession sqlSession;
	
	Logger log = LogManager.getLogger("case3");


	@Override
	public <Optional>PostResponseDto selectPostByPostId(int postId) {;
		String statement = "post.selectPostByPostId";

		return sqlSession.selectOne(statement, postId);
	
	}


	@Override
	public int processVote(VoteRequestDTO requestDTO) throws Exception{
		String statement = "post.insertVote";
		log.info("dao test ");
		int result = sqlSession.insert(statement,requestDTO);
		log.info("result");
		return result;
	}

}
