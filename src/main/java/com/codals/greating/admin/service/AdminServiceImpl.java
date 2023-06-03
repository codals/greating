package com.codals.greating.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codals.greating.admin.dao.AdminDao;
import com.codals.greating.admin.dto.AdminDto;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao dao;
	
	@Override
	public List<AdminDto> topList() {
		return dao.topList();
	}

	@Override
	public boolean approveCheck(long postId) {
		return dao.approveCheck(postId);
	}

}
