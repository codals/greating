package com.codals.greating.diy.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.exception.BusinessException;
import com.codals.greating.exception.ErrorCode;

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
	public Integer savePost(Post post) {
	    String insertStatement = "post.insertPost";
	    String selectStatement = "post.selectLastInsertedId";
	    String sequenceStatement = "post.nextPostId";
	    
		log.info("post 저장 전=" + post);

	    // 게시글을 삽입합니다.
	    int rowsAffected = sqlSession.insert(insertStatement, post);
	    if (rowsAffected == 0) {
	        throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR);
	    }
	    
	    // 시퀀스의 NEXTVAL을 사용하여 다음 ID 값을 생성합니다.
	    int nextVal = sqlSession.selectOne(sequenceStatement);
	    log.info("nextVal=" + nextVal);
	    
//	    int curVal = sqlSession.selectOne(selectStatement);
//	    log.info("curVal=" + curVal);
	    
	    // 생성된 게시글의 ID 값을 조회합니다.
//	    Integer postId = sqlSession.selectOne(selectStatement);
	    Integer postId = post.getId();
		log.info("post 저장 직후=" + post);
	    log.info("postId=" + postId);
	    return nextVal-1;
	}


}
