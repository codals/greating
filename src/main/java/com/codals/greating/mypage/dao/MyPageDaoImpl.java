package com.codals.greating.mypage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codals.greating.mypage.dto.MyPageDto;
import com.codals.greating.mypage.dto.MyPageScrapDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyPageDaoImpl implements MyPageDao {
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<MyPageDto> diyList(MyPageDto dto) {
	    return sqlsession.selectList("mypage.diyList", dto);
	}

	@Override
	public List<MyPageDto> scrapList(MyPageScrapDto dto) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("mypage.scrapList", dto);
	}

	@Override
	public List<MyPageDto> voteList(MyPageScrapDto dto) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("mypage.voteList", dto);
	}

	@Override
	public int getTotalPageCount(long userId) {
		return sqlsession.selectOne("mypage.getTotalPageCount", userId);
	}


}
