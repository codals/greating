package com.codals.greating.diy.dao;

import static com.codals.greating.constant.PostStatus.VOTE_FINISHED;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.codals.greating.diy.dto.CommentResponseDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.PostStaticResponseDto;
import com.codals.greating.diy.dto.ScrapRequestDto;
import com.codals.greating.diy.dto.SearchRequestDto;
import com.codals.greating.diy.dto.SimplePostDto;
import com.codals.greating.diy.dto.VoteRequestDto;
import com.codals.greating.diy.entity.Comment;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.diy.entity.Scrap;
import com.codals.greating.diy.entity.Vote;
import com.codals.greating.exception.BusinessException;
import com.codals.greating.exception.ErrorCode;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class DiyDAOImpl implements DiyDAO {
	
	private final SqlSession sqlSession;
	
	@Override
	public PostResponseDto selectPostByPostId(int postId) {;
		String statement = "post.selectPostByPostId";
		return sqlSession.selectOne(statement, postId);
	}

	@Override
	public Integer savePost(Post post) {
	    String insertStatement = "post.insertPost";
	    String sequenceStatement = "post.nextPostId";
	    
	    // 게시글을 삽입합니다.
	    int rowsAffected = sqlSession.insert(insertStatement, post);
	    if (rowsAffected == 0) {
	        throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR);
	    }
	    
	    // 시퀀스의 NEXTVAL을 사용하여 다음 ID 값을 생성합니다.
	    int nextVal = sqlSession.selectOne(sequenceStatement);
	  
	    // 생성된 게시글의 ID 값을 조회합니다.
	    return nextVal-1;
	}

	@Override
	public int insertScrap(ScrapRequestDto requestDto) {
		String statement = "post.insertScrap";
		return sqlSession.insert(statement, requestDto);
	}

	@Override
	public int deleteScrap(ScrapRequestDto requestDto) {
		String statement = "post.deleteScrap";
		return sqlSession.delete(statement, requestDto);
	}

	@Override
	public int insertVote(VoteRequestDto requestDto) throws Exception{
		String statement = "post.insertVote";
		return sqlSession.insert(statement,requestDto);
	}

	@Override
	public int deleteVote(VoteRequestDto requestDto) throws Exception {
		String statement = "post.deleteVote";
		return sqlSession.delete(statement, requestDto);
	}

	@Override
	public List<Post> selectPostsByMainCategory(int id) {
		String statement = "post.selectPostsByMainCategory";
		return sqlSession.selectList(statement,id);
	}

	@Override
	public List<SimplePostDto> selectPostBySearchConditions(SearchRequestDto requestDto) {
		return sqlSession.selectList("post.selectPostBySearchConditions", requestDto);
	}
	
	@Override
    public int getTotalSearchResultCount(SearchRequestDto requestDto) {
		return sqlSession.selectOne("post.countTotalPostBySearchConditions", requestDto);
    }

	@Override
	public Vote selectVoteByPostIdAndUserId(VoteRequestDto requestDto) {
		String statement ="post.selectVoteByPostIdAndUserId";
		return sqlSession.selectOne(statement,requestDto);
	}

	@Override
	public Scrap selectScrapByPostIdAndUserId(ScrapRequestDto requestDto) {
		String statement ="post.selectScrapByPostIdAndUserId";
		return sqlSession.selectOne(statement,requestDto);
	}

	@Override
	public int updateExpiredPostStatus() {
		int voteFinishedId = VOTE_FINISHED.getId();
		return sqlSession.update("post.updateStatusOfExpiredPosts", voteFinishedId);
	}

  @Override
  public List<SimplePostDto> selectPostsBySubCategory(int subCategoryId) {
		String statement ="post.selectPostsBySubCategory";
		return sqlSession.selectList(statement, subCategoryId);
	}

	@Override
	public PostStaticResponseDto selectPostVoteStatics(int postId) {
		String statement ="post.selectPostVoteStatics";
		return sqlSession.selectOne(statement,postId);
	}

	@Override
	public List<CommentResponseDto> selectComments(int postId) {
		String statement ="post.selectComments";
		return sqlSession.selectList(statement, postId);
	}

	@Override
	public int updateComment(Comment comment) {
		String statement = "post.updateComment";
		return sqlSession.update(statement,comment);
	}

	@Override
	public int insertComment(Comment comment) {
		String statement = "post.insertComment";
		sqlSession.insert(statement, comment);
		return comment.getId();
	}

	@Override
	public CommentResponseDto selectCommentById(int commentId) {
		String statement ="post.selectCommentById";
		return sqlSession.selectOne(statement, commentId);
	}

	@Override
	public int deleteCommentById(int commentId) {
		String statement ="post.deleteCommentById";
		return sqlSession.delete(statement, commentId);
	}

}
