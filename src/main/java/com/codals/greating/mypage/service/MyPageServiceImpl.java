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
		int rowsPerPage = 5; // 한 페이지에 표시할 항목의 수
		int startRow = (page - 1) * rowsPerPage + 1; //현재 페이지에서 첫 번째 항목의 인덱스
		int endRow = startRow + rowsPerPage - 1;
		dto.setStartRow(startRow-1);
        dto.setEndRow(endRow-startRow+1);
        
        //total
        int totalCount = dao.getMyPostTotalPageCount(dto.getUserId());
        int totalPage = (int) Math.ceil((double) totalCount / rowsPerPage);
        dto.setTotalPage(totalPage);
        dto.setTotalCount(totalCount);
		return dao.diyList(dto);
	}

	@Override
	public List<MyPageDto> scrapList(MyPageScrapDto dto, int page) {
		int rowsPerPage = 6;
		int startRow = (page - 1) * rowsPerPage + 1;
		int endRow = startRow + rowsPerPage - 1;
		dto.setStartRow(startRow-1);
        dto.setEndRow(endRow-startRow+1);
        
        //total
        int totalCount = dao.getMyScrapTotalPageCount(dto.getUserId());
        int totalPage = (int) Math.ceil((double) totalCount / rowsPerPage);
        dto.setTotalCount(totalCount);
        dto.setTotalPage(totalPage);
		return dao.scrapList(dto);
	}

	@Override
	public List<MyPageDto> voteList(MyPageScrapDto dto, int page) {
		int rowsPerPage = 6;
		int startRow = (page - 1) * rowsPerPage + 1;
		int endRow = startRow + rowsPerPage - 1;
		dto.setStartRow(startRow-1);
        dto.setEndRow(endRow-startRow+1);
        
        //total
        int totalCount = dao.getMyVoteTotalPageCount(dto.getUserId());
        int totalPage = (int) Math.ceil((double) totalCount / rowsPerPage);
        
        dto.setTotalCount(totalCount);
        dto.setTotalPage(totalPage);
		return dao.voteList(dto);
	}

}
