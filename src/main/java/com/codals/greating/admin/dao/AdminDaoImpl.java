package com.codals.greating.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codals.greating.admin.dto.AdminDto;
@Component
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	SqlSession sqlsession;
	

	@Override
	public List<AdminDto> topList() {
		return sqlsession.selectList("admin.topList");
	}


	@Override
	public boolean approveCheck(long postId) {
		int updatedRows = sqlsession.update("admin.approveCheck", postId);
	    return updatedRows > 0;
	}

}
