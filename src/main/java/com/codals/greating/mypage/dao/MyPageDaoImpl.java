package com.codals.greating.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codals.greating.mypage.dto.MyPageDto;

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


}
