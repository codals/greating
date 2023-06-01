package com.codals.greating.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codals.greating.mypage.dao.MyPageDao;
import com.codals.greating.mypage.dto.MyPageDto;
import com.codals.greating.mypage.dto.MyPageScrapDto;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDao dao;

	@Override
	public List<MyPageDto> diyList(MyPageDto dto, int page) {
		int rowsPerPage = 5;
		int startRow = (page - 1) * rowsPerPage + 1;
		int endRow = startRow + rowsPerPage - 1;
		dto.setStartRow(startRow-1);
        dto.setEndRow(endRow-startRow+1);
        
        System.out.println("page : " + page + " startRow : "+ startRow + " endRow : " + endRow );
        
        //total
        int totalCount = dao.getTotalPageCount(dto.getUserId());
        int totalPage = (int) Math.ceil((double) totalCount / rowsPerPage);
        dto.setTotalPage(totalPage);
        
		return dao.diyList(dto);
	}

	@Override
	public List<MyPageDto> scrapList(MyPageScrapDto dto) {
		return dao.scrapList(dto);
	}

	@Override
	public List<MyPageDto> voteList(MyPageScrapDto dto) {
		return dao.voteList(dto);
	}

}
